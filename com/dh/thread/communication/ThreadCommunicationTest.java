package com.dh.thread.communication;

public class ThreadCommunicationTest {

    public static void main(String[] args) {

        Desk desk = new Desk();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    desk.put();
                }
            }
        }, "厨师1");
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    desk.put();
                }
            }
        }, "厨师2");
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    desk.put();
                }
            }
        }, "厨师3");


        t1.start();
        t2.start();
        t3.start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    desk.get();
                }
            }
        }, "吃货1").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    desk.get();
                }
            }
        }, "吃货2").start();

    }

}
