package com.dh.net.tcp.bs;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟BS通信架构
 */
public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("服务端启动成功----------------");

        ServerSocket server = new ServerSocket(7777);

        while (true){

            Socket socket = server.accept();
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());

            new ServerReaderThread(socket).start();

        }

    }

}
