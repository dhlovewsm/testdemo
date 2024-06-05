package com.dh.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * UDP通信，多发多收
 */
public class Client1 {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true) {
//            byte[] buff = "我爱你".getBytes(StandardCharsets.UTF_8);
            System.out.println("请输入消息：");
            String msg = sc.nextLine();
            if ("exit".equals(msg)){
                System.out.println("欢迎下次光临，退出成功");
                socket.close();
                break;
            }
            byte[] buff = msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket p = new DatagramPacket(buff, buff.length,
                    InetAddress.getLocalHost(), 6666);


            socket.send(p);
        }

//        System.out.println("客户端数据发送完毕------------");
//        socket.close();     //释放资源

    }

}
