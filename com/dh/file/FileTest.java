package com.dh.file;

import java.io.File;
import java.io.IOException;

public class FileTest {




    public static void main(String[] args) {

        System.out.println(factorial(5));

        System.out.println(f(5));

        searchFile(new File("D:/Tencent"), "QQ.exe");


    }


    //直接递归
    public static void test1(){
        test1();
    }

    //计算n的阶乘
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    //1+2+3+4+...+n
    public static int f(int n){
        if (n==1){
            return 1;
        }else {
            return f(n - 1) + n;
        }
    }


    /**
     * 目录下搜索某个文件
     * @param dir 目录
     * @param fileName 文件名称
     */
    public static void searchFile(File dir, String fileName){
        if (dir == null || !dir.exists() || dir.isFile()){
            return;
        }
        File[] files = dir.listFiles();

        if (files != null && files.length > 0){
            for (File f : files) {
                if (f.isFile() && f.getName().contains(fileName)){
                    System.out.println("找到了：" + f.getAbsolutePath());
                    try {
                        Runtime.getRuntime().exec(f.getAbsolutePath());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    searchFile(f, fileName);
                }
            }
        }
    }

    /**
     * 删除非空文件夹
     * @param dir
     */
    public static void deleteFile(File dir){

        if (dir == null || !dir.exists()){
            return;
        }
        if (dir.isFile()){
            dir.delete();
            return;
        }
        File[] files = dir.listFiles();
        if (files == null){
            return;
        }
//        if(files.length == 0){
//            dir.delete();
//            return;
//        }
        for (File f : files) {
            if (f.isFile()){
                f.delete();
            } else {
                deleteFile(f);
            }

        }

        dir.delete();

    }




}
