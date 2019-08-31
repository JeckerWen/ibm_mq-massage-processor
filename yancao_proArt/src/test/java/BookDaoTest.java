import com.wenrj.yc_codecenter.common.constant.ParamConstant;
import com.wenrj.yc_codecenter.system.entity.FeedbackStatus;
import com.wenrj.yc_codecenter.system.service.FeedbackStatusService;
import com.wenrj.yc_codecenter.system.service.SysParamService;
import com.wenrj.yc_codecenter.task.method.Method;
import com.wenrj.yc_codecenter.task.service.*;
import com.wenrj.yc_codecenter.mq.Method.MQMsgMethod;
import com.wenrj.yc_codecenter.xmlAnalysis.XmlAnalysisUtil;
import com.wenrj.yc_codecenter.task.entity.*;
import com.wenrj.yc_codecenter.common.util.BeanUtil;
import com.wenrj.yc_codecenter.common.util.DateUtil;
import com.wenrj.yc_codecenter.common.util.FeedBackUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.*;

public class BookDaoTest extends BaseTest {

    Logger logger = Logger.getLogger(BookDaoTest.class);

    @Autowired
    private HeadInfoService headInfoService;

    @Autowired
    private FeedBackInfoService feedBackInfoService;

    @Autowired
    private DeptInfoService deptInfoService;

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @Autowired
    private Method method;

    @Autowired
    private SysParamService sysParamService;

    @Autowired
    private FeedbackStatusService feedbackStatusService;

    @Test
    public void testQueryById() throws Exception {
        logger.debug("lalal");
    }



    @Test
    public void MQParameTest() {
        List<FeedbackStatus> list = new ArrayList<>();
        list = feedbackStatusService.getAllFeedBackStatus();
        System.out.println(list.size());
    }

    @Test
    public void mapToBeanTest() throws Exception {
        HeadInfo headInfo = new HeadInfo();
        Map<String, Object> mapHead = new HashMap<String, Object>();
        Map<String, Object> mapContent = new HashMap<String, Object>();
        Map<String, Object> feedBackMap = new HashMap<String, Object>();
        Object message = null;
        try {
            MQMsgMethod.MQinit();
            message = MQMsgMethod.getMqMessage("false");
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
                feedBackMap = FeedBackUtil.feedBackMqp(mapHead, ParamConstant.feedBackStatusMap.get("000"));
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
        }
    }

}
