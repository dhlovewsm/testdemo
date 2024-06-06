package com.dh.junit;

public class StringUtil {

    public static void printNumber(String name){
        if (name == null){
            System.out.println(0);
            return;
        }
        System.out.println("名字的长度：" + name.length());

    }

    public static int getMaxIndex(String data){
        if (data == null || data.isEmpty()){
            return -1;
        }
        return data.length() - 1;
    }

}
