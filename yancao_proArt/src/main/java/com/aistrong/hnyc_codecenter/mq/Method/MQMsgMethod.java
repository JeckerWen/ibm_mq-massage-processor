package com.aistrong.hnyc_codecenter.mq.Method;

import com.aistrong.hnyc_codecenter.common.paramInit.MqParamInit;
import com.ibm.mq.*;
import com.aistrong.hnyc_codecenter.mq.MQconstant.MqParamConstant;
import com.ibm.mq.constants.MQConstants;

import java.io.IOException;
import java.util.Date;

/**
 * @Desc: 队列管理器通信方法类
 * @Author: WenRj
 * @Date: 2019/3/13
 */


public class MQMsgMethod {
    /**
     *创建一个队列管理器 qMgr对象, 和对列 mqQueue对象
     */
    private static MQQueue mqQueue;
    private static MQQueueManager qMgr;
    /**
     * 获取队列管理名字
     */
    private static String qManagerName = MqParamConstant.MqParamMap.get(MqParamConstant.MQ_QUEUEMANAGERNAME);
    /**
     * 接收队列名字
     */
    private static String receiveQueueName = MqParamConstant.MqParamMap.get(MqParamConstant.MQ_QUEUENAME_RECEIVE);
    /**
     * 发送队列名称
     */
    private static String sendQueueName = MqParamConstant.MqParamMap.get(MqParamConstant.MQ_QUEUENAME_SEND);
    /**
     * 队列管理器所在ip
     */
    private static String hostName = MqParamConstant.MqParamMap.get(MqParamConstant.MQ_HOSTNAME);
    /**
     * 通道名字
     */
    private static String channelName = MqParamConstant.MqParamMap.get(MqParamConstant.MQ_CHANNEL);
    /**
     * 队列管理器开放的端口
     */
    private static int port = Integer.parseInt(String.valueOf(MqParamConstant.MqParamMap.get(MqParamConstant.MQ_PORT)));
    /**
     * 字符集编码
     */
    private static int CCSID = Integer.parseInt(String.valueOf(MqParamConstant.MqParamMap.get(MqParamConstant.MQ_CCSID)));
    /**
     *定义队列默认属性
     */
    private static int qOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_INQUIRE | MQConstants.MQOO_OUTPUT;

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

    /**
     * @Desc: 发送消息到队列
     * @Author: WenRj
     * @param: qByte: 将要发送的消息
     * @return:
     * @Date: 2019/4/13
     */

    public static void SendMsg(byte[] qByte) {
        try {
            MQMessage qMsg = new MQMessage();
            qMsg.write(qByte); //以字节流的方式发送消息
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            mqQueue = qMgr.accessQueue(sendQueueName, qOptions);
            mqQueue.put(qMsg, pmo);
        } catch (MQException e) {
            release();
            e.printStackTrace();
            System.out
                    .println("A WebSphere mq error occurred : Completion code "
                            + e.completionCode + " Reason Code is "
                            + e.reasonCode);
        } catch (java.io.IOException e) {
            release();
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
     public static String getMQMsgByClean() {
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
        try {
            mqQueue = qMgr.accessQueue(receiveQueueName, openOptions);
            int depth = mqQueue.getCurrentDepth();
            if (depth == 0) {
                release();
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
            release();
            mqe.printStackTrace();
        } catch (Exception e) {
            release();
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Desc: 以浏览的方式接收消息，不会消费消息
     * @Author: WenRj
     * @param:
     * @return: 返回这次的消息字符串
     * @Date: 2019/4/13
     */
    public static String getMsgByBrowse() {
        boolean firstBrowsed = false;
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE | MQConstants.MQOO_BROWSE;
        MQMessage mqMsg = new MQMessage();
        MQGetMessageOptions mqGetMsgOpts = new MQGetMessageOptions();
        try {
            mqQueue =qMgr.accessQueue(receiveQueueName, openOptions);
            if (mqQueue.getCurrentDepth() == 0) {
                release();
                System.out.println("消息队列为空"+ (new Date()).toString());
                return null;
            }
            if (!firstBrowsed) {
                mqGetMsgOpts.options |= MQConstants.MQGMO_WAIT | MQConstants.MQGMO_BROWSE_FIRST;
            } else {
                mqGetMsgOpts.options |= MQConstants.MQGMO_WAIT | MQConstants.MQGMO_BROWSE_NEXT;
            }
            mqQueue.get(mqMsg, mqGetMsgOpts);
            int length = mqMsg.getDataLength();
            byte[] msg = new byte[length];
            mqMsg.readFully(msg);
            String sMsg = new String(msg, "UTF-8");
            return sMsg;
        } catch (MQException mqe) {
            release();
            mqe.printStackTrace();
        } catch (Exception e) {
            release();
            e.printStackTrace();
        }
        return null;
    }

    public static String GetMsg() {
        try {
            MQMessage retrievedMessage = new MQMessage();
            MQGetMessageOptions gmo = new MQGetMessageOptions();
            mqQueue = qMgr.accessQueue(receiveQueueName, qOptions);
            gmo.options += MQConstants.MQPMO_SYNCPOINT;
            mqQueue.get(retrievedMessage, gmo);
            int length = retrievedMessage.getDataLength();
            if (length == 0) {
                System.out.println("消息队列为空"+ (new Date()).toString());
            }
            byte[] msg = new byte[length];
            retrievedMessage.readFully(msg);
            String sMsg = new String(msg, "UTF-8");
            return sMsg;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Desc: 释放消息队列资源, 断开队列管理器连接
     * @Author: WenRj
     * @param:
     * @return:
     * @Date: 2019/4/13
     */
    public  static void  release(){
        try {
            mqQueue.close();
            qMgr.disconnect();
        } catch (MQException e) {
            System.out
                    .println("A WebSphere mq error occurred : Completion code "
                            + e.completionCode + " Reason Code is "
                            + e.reasonCode);
        }
    }

    /**
     * @Desc: 接收消息整合方法, 通过参数isClean设置是进行消费消息操作或是浏览消息操作
     * @Author: WenRj
     * @param: isClean: 1.true: 进行消费消息操作; 2.false: 进行浏览消息操作
     * @return: 返回获取到消息的字符串
     * @Date: 2019/4/13
     */
    public static String getMqMessage(String isClean) {
        if (isClean.equals("true")) {
            return getMQMsgByClean();
        } else {
            return getMsgByBrowse();
        }
    }

}
