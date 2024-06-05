package com.dh.thread;

public class PullMoneyThread extends Thread{

    private Account account;

    public PullMoneyThread(Account account, String name){
        super(name);
        this.account = account;
    }

    @Override
    public void run() {

        account.drawMoney(100000);
    }
}
