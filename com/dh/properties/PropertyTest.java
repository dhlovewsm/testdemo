package com.dh.properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;


/**
 * 读取Properties文件
 */
public class PropertyTest {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.load(new BufferedInputStream(new FileInputStream("test.properties")));
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("gender"));

        System.out.println(properties);

        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            String value = properties.getProperty(key);
            System.out.println(key + "-->" + value);
        }

        properties.forEach((k, v) -> System.out.println(k + "-->" + v));


        /**
         * 写入文件
         */
        properties.setProperty("address", "hangzhou");
        properties.store(new FileWriter("test1.properties"), "saved address");


    }

}
