import com.wenrj.yc_codecenter.task.method.Method;
import com.wenrj.yc_codecenter.task.service.FeedBackInfoService;
import com.wenrj.yc_codecenter.task.service.HeadInfoService;
import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {
    private static MQQueue mqQueue;
    private static MQQueueManager qMgr;
    /**
     * 获取队列管理名字
     */
    private static String qManagerName = "MQ_ORANGE";
    /**
     * 接收队列名字
     */
    private static String receiveQueueName = "Q2";
    /**
     * 发送队列名称
     */
    private static String sendQueueName = "Q2";
    /**
     * 队列管理器所在ip
     */
    private static String hostName = "localhost";
    /**
     * 通道名字
     */
    private static String channelName = "SERVER.CHANNEL";
    /**
     * 队列管理器开放的端口
     */
    private static int port = 1415;
    /**
     * 字符集编码
     */
    private static int CCSID = 1381;
    /**
     *定义队列默认属性
     */
    private static int qOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_INQUIRE | MQConstants.MQOO_OUTPUT;



    @Autowired
    private HeadInfoService headInfoService;

    @Autowired
    private Method method;

    @Autowired
    private FeedBackInfoService feedBackInfoService;

        /**
     * @Desc: 初始化队列管理器
     * @Author: WenRj
     * @param:
     * @return:
     * @Date: 2019/4/13
     */
    public static void MQinit() {
        try {
            MQEnvironment.hostname = hostName; //设置队列管理者ip
            MQEnvironment.port = port; //设置队列管理者端口
            MQEnvironment.channel = channelName; //设置队列管理者连接通道
            MQEnvironment.CCSID = CCSID; //设置字符集编码
            qMgr = new MQQueueManager(qManagerName);
        } catch (MQException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        String msg = new String("<?xml version=\"1.0\" encoding=\"utf-8\"?><dataset><head><msg_id>MDM_155479` varchar30 DEFAULT NULL COMMENT '‘',587117_7381</msg_id><ws_mark>CYZY_ESB_MDM_BaseCode</ws_mark><ws_method>transBaseCode</ws_method><ws_param>T_b_c_dept</ws_param><curr_time>` varchar30 DEFAULT NULL COMMENT '‘',019-04-09 14:49:47</curr_time><curr_user>编码中心管理员*</curr_user></head>  <datalist> <data><Dept_code>01` varchar30 DEFAULT NULL COMMENT '‘',4310010` varchar30 DEFAULT NULL COMMENT '‘',</Dept_code>  <dept_full_name>郴州市局办公室（烟草学会秘书处、机关服务中心）</dept_full_name>  <dept_name>办公室（烟草学会秘书处、机关服务中心）</dept_name>  <Dept_in_corp>01111431001</Dept_in_corp>  <Super_dept_code>01` varchar30 DEFAULT NULL COMMENT '‘',431001</Super_dept_code>  <dept_type>01500` varchar30 DEFAULT NULL COMMENT '‘',</dept_type>  <status>1</status>  <code_purview>0</code_purview>  <Code_gbm/>  <Code_level>7</Code_level>  <Code_leaf>1</Code_leaf>  <Code_order>` varchar30 DEFAULT NULL COMMENT '‘',</Code_order>  <view_code>00` varchar30 DEFAULT NULL COMMENT '‘',00` varchar30 DEFAULT NULL COMMENT '‘',00104301100100` varchar30 DEFAULT NULL COMMENT '‘',</view_code>  <creator>bmadmin维护*</creator>  <createtime>` varchar30 DEFAULT NULL COMMENT '‘',017-1` varchar30 DEFAULT NULL COMMENT '‘',-` varchar30 DEFAULT NULL COMMENT '‘',` varchar30 DEFAULT NULL COMMENT '‘', 16:3` varchar30 DEFAULT NULL COMMENT '‘',:3` varchar30 DEFAULT NULL COMMENT '‘',</createtime>  <modifier>编码中心管理员*</modifier><modifytime>` varchar30 DEFAULT NULL COMMENT '‘',019-04-09 14:49:35</modifytime> </data> </datalist> </dataset>");
        MQinit();
        try {
            SendMsgTest(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * @Desc: 发送消息到队列
     * @Author: WenRj
     * @param: qByte: 将要发送的消息
     * @return:
     * @Date: 2019/4/13
     */

    public static void SendMsgTest(String qByte) {
        try {
            MQMessage qMsg = new MQMessage();
            qMsg.format = MQConstants.MQFMT_STRING;
            qMsg.characterSet = CCSID;
            qMsg.encoding = CCSID;
            qMsg.writeString(qByte); //以字节流的方式发送消息
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            mqQueue = qMgr.accessQueue(sendQueueName, qOptions);
            mqQueue.put(qMsg, pmo);
        } catch (MQException e) {
            e.printStackTrace();
            System.out
                    .println("A WebSphere mq error occurred : Completion code "
                            + e.completionCode + " Reason Code is "
                            + e.reasonCode);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out
                    .println("An error occurred whilst to the message buffer "
                            + e);
        }

    }

    /**
     * @Desc: 从接收队列中消费消息，并使队列深度-1
     * @Author: WenRj
     * @param:
     * @return: 返回这次消费的消息字符串
     * @Date: 2019/4/13
     */
    public static String getMQMsgByCleanTest() {
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
        try {
            mqQueue = qMgr.accessQueue(receiveQueueName, openOptions);
            int depth = mqQueue.getCurrentDepth();
            if (depth == 0) {
                System.out.println("消息队列为空 "+ (new Date()).toString());
                return null;
            }
            MQMessage getMessage = new MQMessage();
            MQGetMessageOptions gmo = new MQGetMessageOptions();
            mqQueue.get(getMessage, gmo);
            int length = getMessage.getDataLength();
            byte[] msg = new byte[length];
            getMessage.readFully(msg);
            String sMsg = new String(msg, "UTF-8");
            return sMsg;
        } catch (MQException mqe) {
            mqe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


