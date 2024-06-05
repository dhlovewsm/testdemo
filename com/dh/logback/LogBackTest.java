package com.dh.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {

    public static final Logger LOGGER = LoggerFactory.getLogger("LogBackTest");

    public static void main(String[] args) {

        try {
            LOGGER.info("chu()方法开始执行------");
            chu(10, 0);
            LOGGER.info("chu()方法执行成功-----");
        }catch (Exception e){
//            e.printStackTrace();
            LOGGER.error("chu()方法执行失败，出现了bug");
        }

    }

    private static void chu(int a, int b){
        LOGGER.debug("参数a：" + a);
        LOGGER.debug("参数b：" + b);
        int c = a / b;
//        System.out.println("结果是：" + c);
        LOGGER.info("结果是：" + c);
    }

}
