package com.dh.thread.communication;

import java.util.ArrayList;
import java.util.List;

public class Desk {

    private List<String> list = new ArrayList<>();

    public synchronized void put() {
        try {
            String name = Thread.currentThread().getName();
            if (list.isEmpty()){
                list.add(name + "做的肉包子");
                System.out.println(name + "做的肉包子----------------");
                Thread.sleep(2000);

                this.notifyAll();
                this.wait();
            }else {
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public synchronized void get() {
        try {
            String name = Thread.currentThread().getName();
            if (!list.isEmpty()){
                System.out.println(name + "吃了：" + list.get(0));
                list.clear();
                Thread.sleep(1000);

                this.notifyAll();
                this.wait();
            }else {
                this.notifyAll();
                this.wait();
            }
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
