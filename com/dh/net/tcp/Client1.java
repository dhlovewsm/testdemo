package com.dh.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP
 * 一发一收
 */
public class Client1 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 7777);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入消息：");
            String msg = sc.nextLine();
            if ("exit".equals(msg)){
                dos.close();
                socket.close();
                System.out.println("欢迎下次光临，退出成功");
                break;
            }

            dos.writeUTF(msg);
            dos.flush();
        }

//        dos.close();
//        socket.close();

    }

}
