package com.dh.net.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server2 {

    private static List<Socket> onlineSockets = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7777);
        System.out.println("服务端已启动----------------------");
        while (true) {

            Socket sock = server.accept();
            onlineSockets.add(sock);
            System.out.println("有人上线了：" + sock.getRemoteSocketAddress());

            new ServerReaderThread(sock).start();

        }

    }


    public static List<Socket> getOnlineSocket(){
        return onlineSockets;
    }

}
