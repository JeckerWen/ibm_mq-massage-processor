package com.aistrong.hnyc_codecenter.xmlAnalysis;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

public class XmlAnalysisUtil {
    public static Map traversNode (Element node) {
        Map map = new HashMap();
        List<Element> listEle = node.elements();
        for (Element element: listEle) {
            map.put(element.getName().toLowerCase(), element.getStringValue());
        }
        return map;
    }

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
