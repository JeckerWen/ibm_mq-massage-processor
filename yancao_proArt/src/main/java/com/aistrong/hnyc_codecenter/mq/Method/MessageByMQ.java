package com.aistrong.hnyc_codecenter.mq.Method;


import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
/**
 * 列出常用的錯誤碼:如下:
 * 2540：通道定义有错误:</p>
 * 		解决方式如下:</p>
 * 			1.进入用户交互界面:runmqsc  QMEMBFE（QMEMBFE为队列管理器名称）
 * 			2.创建相应的服务器连接通道:DEFINE CHANNEL(DC.SVRCONN) CHLTYPE (SVRCONN) REPLACE
 * 2035：授权相关错误:解决方式如下:
 * 		进入用户交互界面:(同上):
 * 	ALTER CHANNEL(DC.SVRCONN) CHLTYPE(SVRCONN) MCAUSER('mqm')
 * 	说明:DC.SVRCONN 服务器连接通道名称 mqm为ibm mq用户名称
 *
 *
 *
 *
 * @author kefan
 *
 */

public class MessageByMQ {

    /**
     * 队列管理器的名称
     */
    private String qManagerName="MQ_ORANGE";

    /**
     * 队列管理器
     */
    private   MQQueueManager qMgr;
    /**
     * 队列名称
     */
    private  String queueName="Q2";
    /**
     * 队列
     */
    private MQQueue qQueue;

    /**
     * mq服务器所在的主机名称
     */
    private String hostname="localhost";
    /**
     * 服务器连接通道名称
     */
    private String channelName="SERVER.CHANNEL";

    /**
     * 监听器监听的端口
     */
    private  int  port=1415;
    /**
     * 传输的编码类型
     */
    private  int CCSID = 1381;

    public  void  init(){
        try {
            MQEnvironment.hostname = this.hostname; // 安裝MQ所在的ip address
            MQEnvironment.port = this.port; // TCP/IP port
            MQEnvironment.channel = this.channelName;
            MQEnvironment.CCSID = CCSID;
//            MQEnvironment.userID = "mqm";
//            MQEnvironment.password = "WENyuJ.8023";

            qMgr = new MQQueueManager(this.qManagerName);
            int qOptioin = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_INQUIRE
                    | MQC.MQOO_OUTPUT;
            qQueue = qMgr.accessQueue(queueName, qOptioin);

        } catch (MQException e) {
            e.printStackTrace();
        }
    }





    /**
     * 发送信息
     */

    public void SendMsg(byte[] qByte) {
        try {
            MQMessage qMsg = new MQMessage();
            qMsg.write(qByte);
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            qQueue.put(qMsg, pmo);
            System.out.println("The message is sent!");
            System.out.println("\tThe message is " + new String(qByte, "UTF-8"));
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
     * 从消息队列取数据
     */
    public void GetMsg() {
        try {
            MQMessage retrievedMessage = new MQMessage();
            MQGetMessageOptions gmo = new MQGetMessageOptions();
            gmo.options += MQC.MQPMO_SYNCPOINT;
            qQueue.get(retrievedMessage, gmo);
            try {
                Object message = retrievedMessage.readObject();
                System.out.println(message.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (MQException e) {
            e.printStackTrace();
            if (e.reasonCode != 2033) // 没有消息
            {
                e.printStackTrace();
                System.out
                        .println("A WebSphere mq error occurred : Completion code "
                                + e.completionCode
                                + " Reason Code is "
                                + e.reasonCode);
            }
        }
    }



    /**
     * 单元测试方法
     */

    public  void  testMQ(){
        MessageByMQ mqst = new MessageByMQ();
        mqst.init();
        try {
            //mqst.SendMsg("你好,Webshpere mq 7.5!".getBytes("UTF-8"));
            mqst.GetMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 释放资源
     */

    public  void  release(){
        try {
            qQueue.close();
            qMgr.disconnect();
        } catch (MQException e) {
            System.out
                    .println("A WebSphere mq error occurred : Completion code "
                            + e.completionCode + " Reason Code is "
                            + e.reasonCode);
        }
    }


    public static void main(String[] args){
        new MessageByMQ().testMQ();
    }


}