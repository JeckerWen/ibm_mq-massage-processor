package com.wenrj.yc_codecenter.common.paramInit;

import com.wenrj.yc_codecenter.mq.MQconstant.MqParamConstant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;


public class MqParamInit extends HttpServlet implements ServletContextListener {
    public void init() throws ServletException {

    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        Properties properties = new Properties();
        InputStream is = null;
        ClassLoader classLoader = MqParamInit.class.getClassLoader();
        URL resource = classLoader.getResource("MQParam.properties");
        String path = null;
        try {
            path = URLDecoder.decode(resource.getPath(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            is = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(is);
            MqParamConstant.MqParamMap.put(MqParamConstant.MQ_HOSTNAME, properties.getProperty(MqParamConstant.MQ_HOSTNAME));
            MqParamConstant.MqParamMap.put(MqParamConstant.MQ_CHANNEL, properties.getProperty(MqParamConstant.MQ_CHANNEL));
            MqParamConstant.MqParamMap.put(MqParamConstant.MQ_PORT, properties.getProperty(MqParamConstant.MQ_PORT));
            MqParamConstant.MqParamMap.put(MqParamConstant.MQ_CCSID, properties.getProperty(MqParamConstant.MQ_CCSID));
            MqParamConstant.MqParamMap.put(MqParamConstant.MQ_QUEUEMANAGERNAME, properties.getProperty(MqParamConstant.MQ_QUEUEMANAGERNAME));
            MqParamConstant.MqParamMap.put(MqParamConstant.MQ_QUEUENAME_RECEIVE, properties.getProperty(MqParamConstant.MQ_QUEUENAME_RECEIVE));
            MqParamConstant.MqParamMap.put(MqParamConstant.MQ_QUEUENAME_SEND, properties.getProperty(MqParamConstant.MQ_QUEUENAME_SEND));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
