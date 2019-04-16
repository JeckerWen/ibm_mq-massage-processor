package com.aistrong.hnyc_codecenter.common.paramInit;

import com.aistrong.hnyc_codecenter.mq.MQconstant.MqParamConstant;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MqParamInit extends HttpServlet implements ServletContextListener {
    public static final Map<String, String> MqParamMap = new HashMap<>();

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
            MqParamMap.put(MqParamConstant.MQ_HOSTNAME, properties.getProperty(MqParamConstant.MQ_HOSTNAME));
            MqParamMap.put(MqParamConstant.MQ_CHANNEL, properties.getProperty(MqParamConstant.MQ_CHANNEL));
            MqParamMap.put(MqParamConstant.MQ_PORT, properties.getProperty(MqParamConstant.MQ_PORT));
            MqParamMap.put(MqParamConstant.MQ_CCSID, properties.getProperty(MqParamConstant.MQ_CCSID));
            MqParamMap.put(MqParamConstant.MQ_QUEUEMANAGERNAME, properties.getProperty(MqParamConstant.MQ_QUEUEMANAGERNAME));
            MqParamMap.put(MqParamConstant.MQ_QUEUENAME_RECEIVE, properties.getProperty(MqParamConstant.MQ_QUEUENAME_RECEIVE));
            MqParamMap.put(MqParamConstant.MQ_QUEUENAME_SEND, properties.getProperty(MqParamConstant.MQ_QUEUENAME_SEND));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
