package com.dh.io;

import java.io.*;

/**
 * 将D盘中的文件复制到E盘中
 */
public class CopyDemo {

    public static void main(String[] args){

        copy("D:\\谷歌浏览器下载\\壁纸\\图片\\wallhaven-725p1y.png", "E:/111.png");

    }


    /**
     * 复制文件
     * @param inPath 源文件路径
     * @param outPath 目标文件路径
     */
    public static void copy(String inPath, String outPath){

        InputStream in = null;
        OutputStream out = null;
        try {

            in = new FileInputStream(inPath);
            out = new FileOutputStream(outPath);

//        out.write(in.readAllBytes());

            int len;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1){
                out.write(buffer, 0, len);
                System.out.println("当前复制字节：" + len);
            }

            System.out.println("复制完成！！");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {


            try {
                //后创建的流先关闭
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 使用try-with-resource方式释放资源
     * 这种方式简化了try-catch-finally方式的臃肿
     * @param inPath
     * @param outPath
     */
    public static void copy1(String inPath, String outPath){

        try (
                /**
                 * 这里只能放置资源对象
                 * 资源：实现AutoCloseable接口的对象
                 */
                InputStream in = new FileInputStream(inPath);
                OutputStream out = new FileOutputStream(outPath)
        ){

//        out.write(in.readAllBytes());

            int len;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1){
                out.write(buffer, 0, len);
                System.out.println("当前复制字节：" + len);
            }

            System.out.println("复制完成！！");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
