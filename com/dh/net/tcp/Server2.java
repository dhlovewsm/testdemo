package com.dh.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(7777);
        while (true) {

            Socket sock = server.accept();


            new ServerReaderThread(sock).start();

        }



    }

}
