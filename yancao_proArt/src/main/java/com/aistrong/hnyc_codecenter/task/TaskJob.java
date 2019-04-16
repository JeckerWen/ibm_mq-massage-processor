package com.aistrong.hnyc_codecenter.task;


import com.aistrong.hnyc_codecenter.common.util.BeanUtil;
import com.aistrong.hnyc_codecenter.common.util.DateUtil;
import com.aistrong.hnyc_codecenter.common.util.FeedBackUtil;
import com.aistrong.hnyc_codecenter.mq.Method.MQMsgMethod;
import com.aistrong.hnyc_codecenter.task.entity.FeedBackInfo;
import com.aistrong.hnyc_codecenter.task.entity.HeadInfo;
import com.aistrong.hnyc_codecenter.task.method.Method;
import com.aistrong.hnyc_codecenter.task.service.FeedBackInfoService;
import com.aistrong.hnyc_codecenter.task.service.HeadInfoService;
import com.aistrong.hnyc_codecenter.xmlAnalysis.XmlAnalysisUtil;
import com.ibm.mq.MQQueueManager;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TaskJob {

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
                feedBackMap = FeedBackUtil.feedBackMqp(mapHead, "001", String.valueOf(System.currentTimeMillis() / 1000));
                String backMsg = XmlAnalysisUtil.mapToXml(feedBackMap);
                try {
                    MQMsgMethod.SendMsg(backMsg.getBytes("UTF-8"));
                    MQMsgMethod.release();
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
                feedBackMap = FeedBackUtil.feedBackMqp(mapHead, "001", String.valueOf(System.currentTimeMillis() / 1000));
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
