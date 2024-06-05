package com.dh.io;

import java.io.*;

public class BufferedInputStreamTest {

    public static void main(String[] args) {

        try (
                InputStream in = new FileInputStream("resource/aaa.txt");
                BufferedInputStream bis = new BufferedInputStream(in);

                OutputStream out = new FileOutputStream("E:/bbb.txt");
                BufferedOutputStream bos = new BufferedOutputStream(out);
                ){

            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
            System.out.println("复制完成");


        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
