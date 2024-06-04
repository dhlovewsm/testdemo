package com.dh.charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String data = "a我m";
        byte[] bytes = data.getBytes();
        System.out.println(Arrays.toString(bytes));

        String decode = new String(bytes);
        System.out.println(decode);


        byte[] bytes1 = data.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));

        String decode1 = new String(bytes1, "GBK");
        System.out.println(decode1);

    }

}
