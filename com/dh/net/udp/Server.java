package com.dh.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(6666);


        byte[] buff = new byte[1024 * 64];
        DatagramPacket p = new DatagramPacket(buff, buff.length);

        socket.receive(p);

        int len = p.getLength();
        System.out.println(new String(buff, 0, len, StandardCharsets.UTF_8));
        System.out.println("服务端接受成功");
        System.out.println(p.getAddress().getHostAddress());
        System.out.println(p.getPort());

//        socket.close();

    }

}
