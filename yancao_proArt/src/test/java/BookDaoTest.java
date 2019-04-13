import com.aistrong.hnyc_codecenter.task.method.Method;
import com.aistrong.hnyc_codecenter.task.service.*;
import com.ibm.mq.MQQueueManager;
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
import java.text.SimpleDateFormat;
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
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setPersoncode("1");
        employeeInfo.setCnname("2");
        employeeInfo.setIdnum("3");
        employeeInfo.setSe("4");
        employeeInfo.setNation("5");
        employeeInfo.setBirthday("6");
        employeeInfo.setAge(111);
        employeeInfo.setNative_place("8");
        employeeInfo.setEducode("9");
        employeeInfo.setGraduate_school("10");
        employeeInfo.setEntrance_date("11");
        employeeInfo.setGraduate_date("12");
        employeeInfo.setEductional_systme("14");
        employeeInfo.setStudy_form("15");
        employeeInfo.setDegreecode("16");
        employeeInfo.setDegree_dept("17");
        employeeInfo.setDegree_date("18");
        employeeInfo.setSpeciality("19");
        employeeInfo.setPcode("20");
        employeeInfo.setMarrycode("21");
        employeeInfo.setHometel("22");
        employeeInfo.setHealth("23");
        employeeInfo.setBeginwork_date("24");
        employeeInfo.setIftran_work("25");
        employeeInfo.setIfe_serviceman("26");
        employeeInfo.setOnduty_date("27");
        employeeInfo.setInsystem_date("28");
        employeeInfo.setWork_date("29");
        employeeInfo.setStation_code("30");
        employeeInfo.setJob("31");
        employeeInfo.setStation_date("32");
        employeeInfo.setStation_type("33");
        employeeInfo.setTitle_tech_post("34");
        employeeInfo.setDeal_level("35");
        employeeInfo.setDeal_date("36");
        employeeInfo.setJob_type("37");
        employeeInfo.setPact_type("38");
        employeeInfo.setWork_spec("39");
        employeeInfo.setStrong_suit("40");
        employeeInfo.setPersonet1("41");
        employeeInfo.setPersonet2("42");
        employeeInfo.setEndowment_insurance("43");
        employeeInfo.setIdleness_insurance("44");
        employeeInfo.setWork_injure("45");
        employeeInfo.setMedicare("46");
        employeeInfo.setBearing_nisurance("47");
        employeeInfo.setRegister_type("48");
        employeeInfo.setReister_adress("49");
        employeeInfo.setSpecialties("50");
        employeeInfo.setEmail("51");
        employeeInfo.setMobile("52");
        employeeInfo.setOfficetel("53");
        employeeInfo.setConnectaddr("53");
        employeeInfo.setOtherinfo("55");
        employeeInfo.setCorp_code("56");
        employeeInfo.setDept_code("a");
        employeeInfo.setEmployeecode("A");
        employeeInfo.setOrderno("B");
        employeeInfo.setUserid("C");
        employeeInfo.setStatus("D");
        employeeInfoService.addEmployeeInfo(employeeInfo);
    }

    @Test
    public void headInfoTest() throws Exception {
        
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
            mapHead.put("rece_info", message);

            Element dataListEle = XmlAnalysisUtil.nextElement(rootEle, 2);
            Element dataEle = XmlAnalysisUtil.nextElement(dataListEle, 1);
            mapContent = XmlAnalysisUtil.traversNode(dataEle);
            System.out.println(mapContent);
            boolean isSuccess = method.infoToDao((String) mapHead.get("ws_param"), mapContent);
            if (isSuccess) {
                BeanUtil.mapToBean(mapHead, headInfo);
                headInfoService.addHeadInfo(headInfo);
                feedBackMap = FeedBackUtil.feedBackMqp(mapHead, "001", String.valueOf(System.currentTimeMillis() / 1000));
                String backMsg = XmlAnalysisUtil.mapToXml(feedBackMap);
                try {
                    MQMsgMethod.MQinit();
                    MQMsgMethod.SendMsg(backMsg.getBytes("UTF-8"));
                } catch (Exception e) {
                    System.out.println("反馈失败, msg_id:" + feedBackMap.get("msg_id"));
                    e.printStackTrace();
                }
                feedBackMap.put("curr_time", DateUtil.strToDate((String) feedBackMap.get("curr_time")));
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
