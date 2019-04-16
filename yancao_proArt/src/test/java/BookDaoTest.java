import com.aistrong.hnyc_codecenter.common.constant.WsParamConstant;
import com.aistrong.hnyc_codecenter.common.paramInit.WsParamInit;
import com.aistrong.hnyc_codecenter.task.method.Method;
import com.aistrong.hnyc_codecenter.task.service.*;
import com.aistrong.hnyc_codecenter.mq.Method.MQMsgMethod;
import com.aistrong.hnyc_codecenter.xmlAnalysis.XmlAnalysisUtil;
import com.aistrong.hnyc_codecenter.task.entity.*;
import com.aistrong.hnyc_codecenter.common.util.BeanUtil;
import com.aistrong.hnyc_codecenter.common.util.DateUtil;
import com.aistrong.hnyc_codecenter.common.util.FeedBackUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

public class BookDaoTest extends BaseTest {


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

    @Test
    public void testQueryById() throws Exception {
    }

    @Test
    public void headInfoTest() throws Exception {
        String cig = WsParamInit.WsParamMap.get(WsParamConstant.T_B_C_CIG);
        System.out.println(cig);
    }

    @Test
    public void MQParameTest() {
        Properties properties = new Properties();
        ClassLoader classLoader = BookDaoTest.class.getClassLoader();
        URL resource = classLoader.getResource("MQParam.properties");
        String path = resource.getPath();
        try {
            path = URLDecoder.decode(path, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(is);
            Object parame = properties.getProperty("MQ_hostname");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xmlTest() {
        String text = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<dataset>\n" +
                "\t<head>\n" +
                "\t\t<msg_id>MDM_TOBACORIG_20110408102522551</msg_id>\n" +
                "\t\t<ws_mark>HNYC_MDM</ws_mark>\n" +
                "\t\t<ws_method>transBaseCode</ws_method>\n" +
                "\t\t<ws_param>T_b_c_dept</ws_param>\n" +
                "\t\t<curr_time>2011-04-08 10:25:22</curr_time>\n" +
                "\t\t<curr_user>icss</curr_user>\n" +
                "\t</head>\n" +
                "<datalist>\n" +
                "<data>\n" +
                "<Dept_code>01243010101</Dept_code>\n" +
                "<dept_name>公司领导层</dept_name>\n" +
                "<dept_full_name>长沙市公司领导层</dept_full_name>\n" +
                "<Dept_in_corp>01111430101</Dept_in_corp>\n" +
                "<Dept_type>015001</Dept_type>\n" +
                "<Super_dept_code >012430101</Super_dept_code>\n" +
                "<status>1</status>\n" +
                "</data>\n" +
                "</datalist>\n" +
                "</dataset>\n";
        try {
            HeadInfo headInfo = new HeadInfo();
            Document document = DocumentHelper.parseText(text);
            Element rootEle = document.getRootElement();
            Element dataListEle = XmlAnalysisUtil.nextElement(rootEle, 2);
            Element dataEle = XmlAnalysisUtil.nextElement(dataListEle, 1);
            System.out.println(XmlAnalysisUtil.traversNode(dataEle));
        } catch (DocumentException de) {
            System.out.println("xml格式错误！");
            de.printStackTrace();
        }
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
            System.out.println((String) mapHead.get("curr_time"));
            mapHead.put("curr_time", DateUtil.strToDate((String) mapHead.get("curr_time")));
            mapHead.put("recv_info", message);
            mapHead.put("recv_time", DateUtil.currTime());

            Element dataListEle = XmlAnalysisUtil.nextElement(rootEle, 2);
            Element dataEle = XmlAnalysisUtil.nextElement(dataListEle, 1);
            mapContent = XmlAnalysisUtil.traversNode(dataEle);
            System.out.println(mapContent);
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
        }
    }

}
