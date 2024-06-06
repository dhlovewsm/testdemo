package com.dh.net.tcp.bs;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable{

    private Socket socket;
    public ServerReaderRunnable(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);

            //按照HTTP协议规范来写
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();       //必须换行
            ps.println("我爱你");

            ps.close();
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
