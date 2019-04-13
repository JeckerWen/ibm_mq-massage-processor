package com.aistrong.hnyc_codecenter.mq.MQUtils;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * @Desc: 队列管理器参数获取类
 * @Author: WenRj
 * @Date: 2019/3/13
 */

public class Property {
    /**
     * @Desc: 获取队列管理器配置文件的配置信息
     * @Author: WenRj
     * @param: key:配置变量名
     * @return: 配置信息
     * @Date: 2019/3/13
     */
    public static Object getParam(String key) {
        Properties properties = new Properties();
        InputStream is = null;
        ClassLoader classLoader = Property.class.getClassLoader();
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
            Object parame = properties.getProperty(key);
            return parame;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
