package com.aistrong.hnyc_codecenter.mq.MQUtils;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;
import com.aistrong.hnyc_codecenter.mq.MQconstant.ConstantMQParam;

/**
 * @Desc: 对列管理器连接类
 * @Author: WenRj
 * @Date: 2019/3/13
 */

public class MQConnect {
    /**
     * @Desc: 连接队列管理器，并获得一个队列管理器对象
     * @Author: WenRj
     * @param:
     * @return: qMgr: 队列管理器对象
     * @Date: 2019/3/13
     */
    public static MQQueueManager getMQManager() throws MQException {
        MQEnvironment.hostname = (String)Property.getParam(ConstantMQParam.MQ_HOSTNAME);
        MQEnvironment.channel = (String)Property.getParam(ConstantMQParam.MQ_CHANNEL);
        MQEnvironment.port = Integer.parseInt(String.valueOf(Property.getParam(ConstantMQParam.MQ_PORT)));
        MQEnvironment.CCSID = Integer.parseInt(String.valueOf(Property.getParam(ConstantMQParam.MQ_CCSID)));
        //MQEnvironment.userID = (String)Property.getParam(ConstantMQParam.MQ_USERID);
        //MQEnvironment.password = (String)Property.getParam(ConstantMQParam.MQ_PASSWORD);
        String MQmanagerName = (String)Property.getParam(ConstantMQParam.MQ_QUEUEMANAGERNAME);
        MQQueueManager qMgr = new MQQueueManager(MQmanagerName);
        return qMgr;
    }

    /**
     * @Desc: 断开队列管理器连接
     * @Author: WenRj
     * @param: qMgr:队列管理器对象
     * @return: 是否断开队列管理器连接
     * @Date: 2019/3/13
     */
    public static boolean disconnMQManager(MQQueueManager qMgr) {
        try {
            qMgr.disconnect();
            return true;
        } catch (MQException mqe) {
            System.out.println("断开队列管理器失败.\n" + mqe);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Desc: 重新连接队列管理器
     * @Author: WenRj
     * @param: qMgr:队列管理器对象
     * @return: 队列管理器对象
     * @Date: 2019/3/13
     */
    public static MQQueueManager reConnMQManager(MQQueueManager qMgr) {
        if (qMgr == null || !qMgr.isConnected()) {
            try {
                qMgr = getMQManager();
                return qMgr;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return qMgr;
    }

}
