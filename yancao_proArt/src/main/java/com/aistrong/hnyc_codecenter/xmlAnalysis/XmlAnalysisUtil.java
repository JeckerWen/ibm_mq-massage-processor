package com.aistrong.hnyc_codecenter.xmlAnalysis;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * @Desc: xml文本格式转换相关方法
 * @Author: WenRj
 * @param:
 * @return:
 * @Date: 2019/4/13
 */


public class XmlAnalysisUtil {
    /**
     * @Desc: 将一个xml数据节点转为Map
     * @Author: WenRj
     * @param: dom4j Element数据节点对象
     * @return: 该节点下的数据Map
     * @Date: 2019/4/13
     */
    public static Map traversNode (Element node) {
        Map map = new HashMap();
        List<Element> listEle = node.elements();
        for (Element element: listEle) {
            map.put(element.getName().toLowerCase(), element.getStringValue());
        }
        return map;
    }

    /**
     * @Desc: 获取该节点的下一个子节点对象
     * @Author: WenRj
     * @param: 1.paratEle: 父节点对象； 2.numEle: 父节点下的第n个子节点
     * @return: dom4j数据节点对象
     * @Date: 2019/4/13
     */
    public static Element nextElement(Element parentEle, int numEle) {
        Iterator parentIter = parentEle.elementIterator();
        Element element = null;
        for (int i = 0; i < numEle; ++i) {
            try {
                element = (Element) parentIter.next();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        return element;
    }
    /**
     * @Desc: 将一个map转为xml数据格式
     * @Author: WenRj
     * @param: map:一个map对象
     * @return: xml格式的字符串
     * @Date: 2019/4/13
     */
    public static String mapToXml(Map map) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element parentroot = document.addElement("dataset");
        Element root = parentroot.addElement("head");
        Set<String> keys = map.keySet();
        for (String key: keys) {
            root.addElement(key).addText((String) map.get(key));
        }
        StringWriter sw = new StringWriter();
        XMLWriter xw = new XMLWriter(sw);
        xw.setEscapeText(false);
        xw.write(document);
        return sw.toString();
    }
}
