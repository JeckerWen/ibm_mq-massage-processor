package com.aistrong.hnyc_codecenter.mq.Method;

import com.ibm.mq.*;
import com.aistrong.hnyc_codecenter.mq.MQUtils.Property;
import com.aistrong.hnyc_codecenter.mq.MQconstant.ConstantMQParam;
import com.ibm.mq.constants.MQConstants;

import java.io.IOException;

/**
 * @Desc: 队列管理器通信方法类
 * @Author: WenRj
 * @Date: 2019/3/13
 */


public class MQMsgMethod {
    private static MQQueue mqQueue;
    private static MQQueueManager qMgr;
    private static String qManagerName = (String) Property.getParam(ConstantMQParam.MQ_QUEUEMANAGERNAME);
    private static String receiveQueueName = (String) Property.getParam(ConstantMQParam.MQ_QUEUENAME_RECEIVE);
    private static String sendQueueName = (String) Property.getParam(ConstantMQParam.MQ_QUEUENAME_SEND);
    private static String hostName = (String) Property.getParam(ConstantMQParam.MQ_HOSTNAME);
    private static String channelName = (String) Property.getParam(ConstantMQParam.MQ_CHANNEL);
    private static int port = Integer.parseInt(String.valueOf(Property.getParam(ConstantMQParam.MQ_PORT)));
    private static int CCSID = Integer.parseInt(String.valueOf(Property.getParam(ConstantMQParam.MQ_CCSID)));
    private static int qOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_INQUIRE | MQC.MQOO_OUTPUT;

    public static void MQinit() {
        try {
            MQEnvironment.hostname = hostName;
            MQEnvironment.port = port;
            MQEnvironment.channel = channelName;
            MQEnvironment.CCSID = CCSID;
            qMgr = new MQQueueManager(qManagerName);
        } catch (MQException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Desc: 连接消息队列，并将消息发送至队列
     * @Author: WenRj
     * @param:  1.qMgr:队列管理器对象   2.message:要发送的消息信息
     * @return:
     * @Date: 2019/3/13
     */
    public static void putMQMsg(MQQueueManager qMgr, String message) {
        int openOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE; //设置访问的消息队列属性
        try {
            mqQueue= qMgr.accessQueue(sendQueueName, openOptions);  //获取一个队列对象
            MQMessage putMessage = new MQMessage();
            putMessage.writeObject(message); //将消息放入缓存，这里是以对象的形式写入的，避免了中文乱码的情况
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            mqQueue.put(putMessage, pmo); //将消息对象中的消息推入消息队列中
            //mqQueue.close();
        } catch (MQException ex) {
            System.out.println("A WebSphere mq error occurred : Completion Method "
                    + ex.completionCode + " Reason Method " + ex.reasonCode);
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("An error occurred whilst writing to the message buffer: " + ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void SendMsg(byte[] qByte) {
        try {
            MQMessage qMsg = new MQMessage();
            qMsg.write(qByte);
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
     * @Desc: 消费消息队列消息, 一次消费的深度为1, 消息队列深度减1
     * @Author: WenRj
     * @param: 1.qMgr: 队列管理器对象
     * @return: 1.msgContent: 消息对象
     * @Date: 2019/3/13
     */
    public static Object getMQMsgByClean(MQQueueManager qMgr) {
        int openOptions = MQConstants.MQOO_FAIL_IF_QUIESCING | MQConstants.MQOO_INPUT_AS_Q_DEF |
                          MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
        try {
            MQQueue mQueue = qMgr.accessQueue(receiveQueueName, openOptions);
            int depth = mQueue.getCurrentDepth(); //获取当前消息队列的深度
            if (depth > 0) {
                MQMessage getMessage = new MQMessage();
                MQGetMessageOptions gmo = new MQGetMessageOptions();
                mQueue.get(getMessage, gmo);
                Object msgContent = getMessage.readObject(); //消费消息队列中的一个消息
                return msgContent;
            } else {
                System.out.println("当前消息队列为空.");
            }
        } catch (MQException mqe) {
            mqe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     public static String getMQMsgByClean2() {
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
        try {
            mqQueue = qMgr.accessQueue(receiveQueueName, openOptions);
            if (mqQueue.getCurrentDepth() == 0) {
                System.out.println("消息队列为空");
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

    public static Object getMsgByBrowse(MQQueueManager qMgr) {
        boolean firstBrowsed = false;
        int openOptions = MQC.MQOO_FAIL_IF_QUIESCING | MQC.MQOO_BROWSE;
        MQQueue mQueue;
        MQMessage mqMsg = new MQMessage();
        MQGetMessageOptions mqGetMsgOpts = new MQGetMessageOptions();
        try {
            mQueue =qMgr.accessQueue(receiveQueueName, openOptions);
            if (!firstBrowsed) {
                mqGetMsgOpts.options |= MQC.MQGMO_WAIT | MQC.MQGMO_BROWSE_FIRST;
            } else {
                mqGetMsgOpts.options |= MQC.MQGMO_WAIT | MQC.MQGMO_BROWSE_NEXT;
            }
            mQueue.get(mqMsg, mqGetMsgOpts);
            if (mqMsg.getMessageLength() > 0) {
                Object message = mqMsg.readObject();
                return message;
            }
        } catch (MQException mqe) {
                mqe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMsgByBrowse2() {
        boolean firstBrowsed = false;
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE | MQC.MQOO_BROWSE;
        MQMessage mqMsg = new MQMessage();
        MQGetMessageOptions mqGetMsgOpts = new MQGetMessageOptions();
        try {
            mqQueue =qMgr.accessQueue(receiveQueueName, openOptions);
            if (mqQueue.getCurrentDepth() == 0) {
                System.out.println("消息队列为空");
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
            mqe.printStackTrace();
        } catch (Exception e) {
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
                System.out.println("消息队列为空");
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

    public static String getMqMessage(String isClean) {
        if (isClean.equals("true")) {
            return getMQMsgByClean2();
        } else {
            return getMsgByBrowse2();
        }
    }

}
