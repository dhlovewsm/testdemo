package com.dh.net.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * UDP通信，1发1收
 */
public class Client {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();

        byte[] buff = "我爱你".getBytes(StandardCharsets.UTF_8);
        DatagramPacket p = new DatagramPacket(buff, buff.length,
                InetAddress.getLocalHost(), 6666);


        socket.send(p);

        System.out.println("客户端数据发送完毕------------");
        socket.close();     //释放资源

    }

}
