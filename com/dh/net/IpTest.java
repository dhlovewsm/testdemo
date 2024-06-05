package com.dh.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpTest {

    public static void main(String[] args) throws IOException {

        /**
         * 获取本机的主机名和ip地址
         */
        InetAddress ip = InetAddress.getLocalHost();

        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());


        /**
         * 获取服务器ip
         */
        InetAddress ip1 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        /**
         * 判断服务器是否联通
         */
        System.out.println(ip1.isReachable(6000));

    }

}
