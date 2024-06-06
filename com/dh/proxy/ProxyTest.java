package com.dh.proxy;

public class ProxyTest {

    public static void main(String[] args) {

        BigStar s = new BigStar("杨超越");
        Star starProxy = ProxyUtil.createProxy(s);

        String str = starProxy.sing("好日子");
        System.out.println(str);

        starProxy.dance();

    }

}
