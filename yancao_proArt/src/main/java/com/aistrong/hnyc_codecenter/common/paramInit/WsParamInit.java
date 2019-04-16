package com.aistrong.hnyc_codecenter.common.paramInit;

import com.aistrong.hnyc_codecenter.common.constant.WsParamConstant;

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

public class WsParamInit extends HttpServlet implements ServletContextListener {
    public static Map<String, String> WsParamMap = new HashMap<>();

    public void init() throws ServletException {

    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        Properties properties = new Properties();
        InputStream is = null;
        ClassLoader classLoader = WsParamInit.class.getClassLoader();
        URL resource = classLoader.getResource("ws_param.properties");
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
            WsParamMap.put(WsParamConstant.T_B_C_EMPLOYEE, properties.getProperty(WsParamConstant.T_B_C_EMPLOYEE));
            WsParamMap.put(WsParamConstant.T_B_C_CORP, properties.getProperty(WsParamConstant.T_B_C_CORP));
            WsParamMap.put(WsParamConstant.T_B_C_DEPT, properties.getProperty(WsParamConstant.T_B_C_DEPT));
            WsParamMap.put(WsParamConstant.T_B_C_REGIONALISM, properties.getProperty(WsParamConstant.T_B_C_REGIONALISM));
            WsParamMap.put(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO, properties.getProperty(WsParamConstant.T_B_C_PROVIDE_DEALER_BASEINFO));
            WsParamMap.put(WsParamConstant.T_B_C_CIG_TRADEMARK, properties.getProperty(WsParamConstant.T_B_C_CIG_TRADEMARK));
            WsParamMap.put(WsParamConstant.T_B_C_CIG, properties.getProperty(WsParamConstant.T_B_C_CIG));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
