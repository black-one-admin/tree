package com.black.one.weixin.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 接收普通信息，xml解析
 *
 * @author swh
 * @create: 2020-05-31 22:49
 */
public class ParseXml {

    public static Map parseXml(HttpServletRequest request) throws Exception {
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        /*
         * 读取request的body内容 此方法会导致流读取问题 Premature end of file. Nested exception:
         * Premature end of file String requestBody
         */
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 将解析结果存储在HashMap中
        // 遍历所有子节点
        Map<String, String> map = elementList.stream().collect(Collectors.toMap(Element::getName, res -> res.getText()));
        // 释放资源
        inputStream.close();
        return map;
    }

}
