package com.dh.net.tcp;

import java.io.*;
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
                    String msg = dis.readUTF();
                    System.out.println(msg);
                    System.out.println(sock.getRemoteSocketAddress());
                    sendToAll(msg);
                } catch (IOException e) {
                    System.out.println(sock.getRemoteSocketAddress() + "离线了！！！");
                    Server2.getOnlineSocket().remove(sock);
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

    private void sendToAll(String msg) throws IOException {

        for (Socket onlineSocket : Server2.getOnlineSocket()){
            OutputStream os = onlineSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(msg);
            dos.flush();
        }

    }
}
