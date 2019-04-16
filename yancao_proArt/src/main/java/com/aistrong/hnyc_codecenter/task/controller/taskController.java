package com.aistrong.hnyc_codecenter.task.controller;

import com.aistrong.hnyc_codecenter.task.method.Method;
import com.aistrong.hnyc_codecenter.task.service.DeptInfoService;
import com.aistrong.hnyc_codecenter.task.service.FeedBackInfoService;
import com.aistrong.hnyc_codecenter.task.service.HeadInfoService;
import com.ibm.mq.MQQueueManager;
import com.aistrong.hnyc_codecenter.mq.Method.MQMsgMethod;
import com.aistrong.hnyc_codecenter.xmlAnalysis.XmlAnalysisUtil;
import com.aistrong.hnyc_codecenter.task.dao.DeptInfoDao;
import com.aistrong.hnyc_codecenter.task.dao.FeedBackInfoDao;
import com.aistrong.hnyc_codecenter.task.dao.HeadInfoDao;
import com.aistrong.hnyc_codecenter.task.entity.DeptInfo;
import com.aistrong.hnyc_codecenter.task.entity.FeedBackInfo;
import com.aistrong.hnyc_codecenter.task.entity.HeadInfo;
import com.aistrong.hnyc_codecenter.common.util.BeanUtil;
import com.aistrong.hnyc_codecenter.common.util.DateUtil;
import com.aistrong.hnyc_codecenter.common.util.FeedBackUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/MQtest")
public class TaskController {
    @Autowired
    private Method method;

    @Autowired
    private HeadInfoService headInfoService;

    @Autowired
    private DeptInfoService deptInfoService;

    @Autowired
    private FeedBackInfoService feedBackInfoService;

    @RequestMapping(value = "/message/{isClean}", method = RequestMethod.GET)
    private void getMqMssage(@PathVariable("isClean") String isClean) throws Exception{
        if (!("true".equals(isClean)) && !("false".equals(isClean))) {
            System.out.println("请输入正确的参数值(true|false).");
            return;
        }
        HeadInfo headInfo = new HeadInfo();
        Map<String, Object> mapHead = new HashMap<String, Object>();
        Map<String, Object> mapContent = new HashMap<String, Object>();
        Map<String, Object> feedBackMap = new HashMap<String, Object>();
        Object message = null;
        try {
            MQMsgMethod.MQinit();
            message = MQMsgMethod.getMqMessage(isClean);
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
        }
    }
}
