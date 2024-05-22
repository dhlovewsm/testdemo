package com.dh.file;

import java.io.File;

public class FileTest {


    public static void main(String[] args) {

        System.out.println(factorial(5));

        System.out.println(f(5));

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


}
