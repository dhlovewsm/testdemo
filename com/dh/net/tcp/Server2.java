package com.dh.net.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(7777);
        while (true) {

            Socket sock = server.accept();
            System.out.println("有人上线了：" + sock.getRemoteSocketAddress());

            new ServerReaderThread(sock).start();

        }



    }

}
