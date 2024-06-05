package com.dh.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReaderThread extends Thread{


    private Socket sock;

    public ServerReaderThread(Socket socket){
        this.sock = socket;
    }

    public Socket getSocket() {
        return sock;
    }

    public void setSocket(Socket socket) {
        this.sock = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = sock.getInputStream();
            DataInputStream dis  = new DataInputStream(is);

            while (true) {
                try {
                    System.out.println(dis.readUTF());
                    System.out.println(sock.getRemoteSocketAddress());
                } catch (IOException e) {
                    System.out.println(sock.getRemoteSocketAddress() + "离线了！！！");
                    try {
                        dis.close();
                        sock.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
