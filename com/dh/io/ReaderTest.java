package com.dh.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 * 使用FileReader按照字符读取文件
 */
public class ReaderTest {

    public static void main(String[] args){

        try (
                Reader reader = new FileReader("resource/aaa.txt");
                ){

            //每次读取一个字符，性能差，浪费资源
//            int read;
//            while((read = reader.read()) != -1){
//                System.out.print((char) read);
//            }

            //每次读取多个字符，性能高
            char[] buffer = new char[10];
            int len;
            while((len = reader.read(buffer)) != -1){
                System.out.print(new String(buffer, 0, len));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
