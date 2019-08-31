package com.wenrj.yc_codecenter.task;


import com.wenrj.yc_codecenter.common.constant.ParamConstant;
import com.wenrj.yc_codecenter.common.exception.BusinessException;
import com.wenrj.yc_codecenter.common.util.BeanUtil;
import com.wenrj.yc_codecenter.common.util.DateUtil;
import com.wenrj.yc_codecenter.common.util.FeedBackUtil;
import com.wenrj.yc_codecenter.mq.Method.MQMsgMethod;
import com.wenrj.yc_codecenter.system.entity.FeedbackStatus;
import com.wenrj.yc_codecenter.task.entity.FeedBackInfo;
import com.wenrj.yc_codecenter.task.entity.HeadInfo;
import com.wenrj.yc_codecenter.task.method.Method;
import com.wenrj.yc_codecenter.task.service.FeedBackInfoService;
import com.wenrj.yc_codecenter.task.service.HeadInfoService;
import com.wenrj.yc_codecenter.xmlAnalysis.XmlAnalysisUtil;
import com.ibm.mq.MQQueueManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class TaskJob {

    public static Logger logger = Logger.getLogger(TaskJob.class);

    @Autowired
    private HeadInfoService headInfoService;

    @Autowired
    private Method method;

    @Autowired
    private FeedBackInfoService feedBackInfoService;

    public void doTaskClean() throws Exception {
        HeadInfo headInfo = new HeadInfo();
        Map<String, Object> mapHead = new HashMap<String, Object>();
        Map<String, Object> mapContent = new HashMap<String, Object>();
        Map<String, Object> feedBackMap = new HashMap<String, Object>();
        String message = null;
        try {
            MQMsgMethod.MQinit();
            message = MQMsgMethod.getMqMessage("true");
        } catch (Exception e) {
            logger.info("获取消息失败");
            e.printStackTrace();
        }
        try {
            if (StringUtils.isEmpty(message)) {
                return;
            }
            Document document = DocumentHelper.parseText(message.toString());
            Element rootEle = document.getRootElement();
            Element headEle = XmlAnalysisUtil.nextElement(rootEle, 1);
            mapHead = XmlAnalysisUtil.traversNode(headEle);
            mapHead.put("curr_time", DateUtil.strToDate((String) mapHead.get("curr_time")));
            mapHead.put("recv_info", message);
            mapHead.put("recv_time", DateUtil.currTime());

            Element dataListEle = XmlAnalysisUtil.nextElement(rootEle, 2);
            Element dataEle = XmlAnalysisUtil.nextElement(dataListEle, 1);
            mapContent = XmlAnalysisUtil.traversNode(dataEle);
            boolean isSuccess = method.infoToDao((String) mapHead.get("ws_param"), mapContent);
            if (isSuccess) {
                BeanUtil.mapToBean(mapHead, headInfo);
                headInfoService.saveAndUpdate(headInfo);
                feedBackMap = FeedBackUtil.feedBackMqp(mapHead, ParamConstant.feedBackStatusMap.get("000"));
                String backMsg = XmlAnalysisUtil.mapToXml(feedBackMap);
                try {
                    MQMsgMethod.SendMsg(backMsg.getBytes("GBK"));
                    MQMsgMethod.release();
                } catch (Exception e) {
                    logger.error("反馈失败, msg_id:" + feedBackMap.get("msg_id"));
                    e.printStackTrace();
                    throw new BusinessException(ParamConstant.feedBackStatusMap.get("203"));
                }
                feedBackMap.put("send_content", backMsg);
                FeedBackInfo feedBackInfo = new FeedBackInfo();
                BeanUtil.mapToBean(feedBackMap, feedBackInfo);
                feedBackInfoService.addFeedBackInfo(feedBackInfo);
            } else {
                throw new BusinessException(ParamConstant.feedBackStatusMap.get("999"));
            }
        } catch (BusinessException bus) {
            /**
             * 统一处理抛出的异常，将异常信息发送至消息队列并将信息存储至数据库
             */
            FeedbackStatus fbStatus = new FeedbackStatus();
            fbStatus = (FeedbackStatus) bus.getObject();
            feedBackMap = FeedBackUtil.feedBackMqp(mapHead, fbStatus);
            String backMsg = XmlAnalysisUtil.mapToXml(feedBackMap);
            try {
                MQMsgMethod.SendMsg(backMsg.getBytes("UTF-8"));
                MQMsgMethod.release();
            } catch (Exception e) {
                logger.error("消息反馈失败,消息id为:" + headInfo.getMsg_id());
                e.printStackTrace();
            }
            feedBackMap.put("send_content", backMsg);
            FeedBackInfo feedBackInfo = new FeedBackInfo();
            BeanUtil.mapToBean(feedBackMap, feedBackInfo);
            feedBackInfoService.addFeedBackInfo(feedBackInfo);
        }
    }

    public void doTaskBrowse() throws Exception{
        HeadInfo headInfo = new HeadInfo();
        Map<String, Object> mapHead = new HashMap<String, Object>();
        Map<String, Object> mapContent = new HashMap<String, Object>();
        Map<String, Object> feedBackMap = new HashMap<String, Object>();
        Object message = null;
        MQQueueManager qMgr = null;
        try {
            MQMsgMethod.MQinit();
            message = MQMsgMethod.getMqMessage("false");
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("获取队列消息失败.");
            e.printStackTrace();
        }
        try {
            if (StringUtils.isEmpty(message)) {
                return;
            }
            Document document = DocumentHelper.parseText(message.toString());
            Element rootEle = document.getRootElement();
            Element headEle = XmlAnalysisUtil.nextElement(rootEle, 1);
            mapHead = XmlAnalysisUtil.traversNode(headEle);
            System.out.println((String) mapHead.get("curr_time"));
            mapHead.put("curr_time", DateUtil.strToDate((String) mapHead.get("curr_time")));
            mapHead.put("recv_info", message);
            mapHead.put("recv_time", DateUtil.currTime());

            Element dataListEle = XmlAnalysisUtil.nextElement(rootEle, 2);
            Element dataEle = XmlAnalysisUtil.nextElement(dataListEle, 1);
            mapContent = XmlAnalysisUtil.traversNode(dataEle);
            boolean isSuccess = method.infoToDao((String) mapHead.get("ws_param"), mapContent);
            if (isSuccess) {
                BeanUtil.mapToBean(mapHead, headInfo);
                headInfoService.saveAndUpdate(headInfo);
                feedBackMap = FeedBackUtil.feedBackMqp(mapHead, (FeedbackStatus) ParamConstant.feedBackStatusMap.get("000"));
                String backMsg = XmlAnalysisUtil.mapToXml(feedBackMap);
                try {
                    MQMsgMethod.MQinit();
                    MQMsgMethod.SendMsg(backMsg.getBytes("UTF-8"));
                } catch (Exception e) {
                    System.out.println("反馈失败, msg_id:" + feedBackMap.get("msg_id"));
                    e.printStackTrace();
                }
                feedBackMap.put("send_content", backMsg);
                FeedBackInfo feedBackInfo = new FeedBackInfo();
                BeanUtil.mapToBean(feedBackMap, feedBackInfo);
                feedBackInfoService.addFeedBackInfo(feedBackInfo);
            }
        } catch (DocumentException de) {
            System.out.println("xml格式错误!");
            de.printStackTrace();
            ;
        }
    }

}
