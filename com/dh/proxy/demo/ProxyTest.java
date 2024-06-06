package com.dh.proxy.demo;

public class ProxyTest {


    public static void main(String[] args) throws InterruptedException {

        UserServiceImpl userImlp = new UserServiceImpl();

        UserService proxy = ProxyUtil.createProxy(userImlp);

        proxy.add("lisi", "123456");
        proxy.delete("lisi");
        proxy.login("lisi", "123456");


    }

}
