package com.dh.thread;

public class PullMoneyTest {

    public static void main(String[] args) {


        Account acc = new Account(100000.0 ,"ICBC-00001");

        new PullMoneyThread(acc, "小明").start();
        new PullMoneyThread(acc, "小红").start();

    }

}
