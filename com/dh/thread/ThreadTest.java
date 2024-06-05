package com.dh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/***
 * 多线程测试
 */
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        int i = 0;
        while (i <= 100){

            Thread t1 = new MyThread();
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
//                for (int i = 1; i <= 5; i++) {
//                    System.out.println("t2执行了-----" + i);
//                }
                    System.out.println("B");
                }
            });

            Callable<String> call = new MyCallable();
            FutureTask<String> f1 = new FutureTask<>(call);
            Thread t3 = new Thread(f1);


            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }

//        String s = f1.get();
//        System.out.println(s);


    }

}
