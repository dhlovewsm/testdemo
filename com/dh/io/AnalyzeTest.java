package com.dh.io;


import java.io.*;

/**
 * 原始流和缓冲流的性能分析
 */
public class AnalyzeTest {


    private static final String SRC_FILE = "D:/AA.exe";
    private static final String DEST_FILE = "D:/";

    public static void main(String[] args) {

        //低级字节流单字节复制，慢的不行！！！ 直接弃用
//        copy1();
        copy2();        //较慢
//        copy3();        //较慢，直接淘汰！！

        //速度最快，推荐使用！！
        copy4();

    }

    /**
     * 原始流
     * 一个字节一个字节复制
     */
    private static void copy1(){

        long start = System.currentTimeMillis();

        try(
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE + "1.exe");
                ){

            int b;
            while((b = is.read()) != -1){
                os.write(b);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("原始流单字节复制耗时：" + time);

    }

    /**
     * 原始流
     * 字节数组复制
     */
    private static void copy2(){

        long start = System.currentTimeMillis();
        try(
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE + "2.exe");
                ){

            byte[] buffer = new byte[1024 * 32];
            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("原始流字节数组复制耗时：" + time);

    }

    /**
     * 缓冲流
     * 单字节复制
     */
    private static void copy3(){

        long start = System.currentTimeMillis();
        try(
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE + "3.exe");
                BufferedInputStream bis = new BufferedInputStream(is);
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ){

            int len;
            while ((len = bis.read()) != -1){
                bos.write(len);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("缓冲流单字节复制耗时：" + time);

    }


    /**
     * 缓冲流
     * 字节数组复制
     */
    private static void copy4(){

        long start = System.currentTimeMillis();
        try(
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE + "4.exe");
                BufferedInputStream bis = new BufferedInputStream(is, 1024* 32);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024* 32);
        ){

            byte[] buff = new byte[1024 * 32];
            int len;
            while ((len = bis.read(buff)) != -1){
                bos.write(buff, 0, len);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("缓冲流字节数组复制耗时：" + time);

    }


}
