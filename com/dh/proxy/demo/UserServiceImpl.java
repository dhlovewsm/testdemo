package com.dh.proxy.demo;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String username, String password) throws InterruptedException {
        System.out.println("=======================login-=========");
        Thread.sleep(1000);
    }

    @Override
    public void delete(String username) throws InterruptedException {
        System.out.println("=======================delete-=========");
        Thread.sleep(1500);
    }

    @Override
    public void add(String username, String password) throws InterruptedException {
        System.out.println("=======================add-=========");
        Thread.sleep(500);
    }
}
