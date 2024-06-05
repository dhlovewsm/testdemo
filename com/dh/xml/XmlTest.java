package com.dh.xml;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 读写xml文件
 */
public class XmlTest {

    public static void main(String[] args) throws DocumentException, IOException {

        Document document = SAXReader.createDefault().read("test.xml");

        Element root = document.getRootElement();
        System.out.println(root.getName());
        List<Element> users = root.elements("user");

        for (Element user : users) {
            System.out.println(user.getName());
            System.out.println(user.elementText("name"));
            System.out.println(user.elementTextTrim("data1"));
            System.out.println(user.element("data").getTextTrim());
            System.out.println(user.attributeValue("id"));
        }

        write();



    }

    /**
     * 写数据到xml文件
     * 使用字符拼接方式
     * 不建议使用dom4j方式来操作
     */
    private static void write(){

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<book>\n");
        sb.append("\t<name>").append("从入门到入土").append("</name>\n");
        sb.append("\t<author>").append("dlei").append("</author>\n");
        sb.append("\t<price>").append(99.99).append("</price>\n");
        sb.append("</book>\n");

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("book.xml"));
                ){
            bw.write(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
