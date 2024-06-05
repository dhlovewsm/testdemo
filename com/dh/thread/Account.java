package com.dh.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private double money;  //余额

    private String cardId;


    private final Lock lock = new ReentrantLock();

    public Account() {
    }

    public Account(double money, String cardId) {
        this.money = money;
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 同步方法方式实现线程同步
     * @param money
     */
    public synchronized void drawMoney(double money) {

        String name = Thread.currentThread().getName();

        /**
         * 同步代码块方式实现线程同步
         */
        synchronized (this) {
            if (this.money >= money){
                System.out.println(name + "取钱" + money + "成功");
                this.money -= money;
                System.out.println(name + "取钱后余额：" + this.money);
            }else {
                System.out.println(name + "取钱，余额不足");
            }
        }

        /**
         * 使用Lock锁来实现线程同步
         */
        lock.lock();
        try {
            if (this.money >= money){
                System.out.println(name + "取钱" + money + "成功");
                this.money -= money;
                System.out.println(name + "取钱后余额：" + this.money);
            }else {
                System.out.println(name + "取钱，余额不足");
            }
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
