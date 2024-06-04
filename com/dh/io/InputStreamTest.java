package com.dh.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class InputStreamTest {

    public static void main(String[] args) throws IOException {

        InputStream in = new FileInputStream("aaa.txt");

//        System.out.println((char) in.read());
//        int i;
//        while ((i = in.read()) != -1){
//            System.out.print((char) i);
//        }
//
//        in.close();

//        byte[] buffer = new byte[3];
//        int read;
//
//        while ((read = in.read(buffer))  != -1){
//            String s = new String(buffer, 0, read);
//            System.out.print(s);
////            System.out.println("当前读取字节数：" + read);
//        }
//        in.close();

        byte[] bytes = in.readAllBytes();
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);

        in.close();

    }

}
