package com.dh.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {

//        for (int i = 1; i <= 5; i++) {
//            System.out.println("t3执行了-----" + i);
//        }
        System.out.println("C");
        return "线程t3成功执行了----------------";
    }
}
