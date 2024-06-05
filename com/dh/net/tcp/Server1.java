package com.dh.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(7777);

        Socket sock = server.accept();

        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        while (true) {
            try {
                System.out.println(dis.readUTF());
                System.out.println(sock.getRemoteSocketAddress());
            } catch (IOException e) {
                System.out.println(sock.getRemoteSocketAddress() + "离线了！！！");
                dis.close();
                sock.close();
                break;
            }

        }
    }

}
