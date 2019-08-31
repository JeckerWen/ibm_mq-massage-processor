package com.wenrj.yc_codecenter.common.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class BeanUtil {
/*
    public static Object mapToBean(Map map, Object obj){
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property: propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            System.out.println("mapToBean Error." + e);
        }
        return obj;
    }
*/
    public static Map<String, Object> beanToMap(Object bean) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(), Object.class);
        PropertyDescriptor[] list = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd: list) {
            String key = pd.getName();
            Object value = pd.getReadMethod().invoke(bean);
            map.put(key, value);
        }
        return map;
    }
    public static void mapToBean(Map map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            //ConvertUtils.register(new org.apache.commons.beanutils.converters.SqlDateConverter(null), java.sql.Date.class);
            //ConvertUtils.register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.util.Date.class);
            ConvertUtils.register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), Timestamp.class);
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
