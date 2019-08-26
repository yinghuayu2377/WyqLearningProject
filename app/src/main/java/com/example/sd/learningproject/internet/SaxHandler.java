package com.example.sd.learningproject.internet;

import android.util.Log;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    private String nodeName;
    private StringBuilder city;
    private StringBuilder updatetime;
    private StringBuilder wendu;

    @Override
    public void startDocument() throws SAXException {  // 开始解析xml时调用
        city = new StringBuilder();
        updatetime = new StringBuilder();
        wendu = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {  // 开始解析某个节点时调用
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException { // 获取节点内容时调用
        if ("city".equals(nodeName)) {
            city.append(ch, start, length);
        } else if ("updatetime".equals(nodeName)) {
            updatetime.append(ch, start, length);
        } else if ("wendu".equals(nodeName)) {
            wendu.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException { // 完成解析某个节点时调用
        if ("resp".equals(localName)) {
            Log.e("TAG", "city:" + city + "updatetime:" + updatetime + "wendu:" + wendu);
            city.setLength(0);
            updatetime.setLength(0);
            wendu.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException { // 完成整个xml解析时调用
        super.endDocument();
    }
}
