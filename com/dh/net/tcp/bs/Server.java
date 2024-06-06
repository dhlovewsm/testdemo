package com.dh.net.tcp.bs;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 模拟BS通信架构
 */
public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("服务端启动成功----------------");

        ServerSocket server = new ServerSocket(7777);

        //创建线程池来处理任务队列
        ThreadPoolExecutor pool = new ThreadPoolExecutor(16 * 2, 16 * 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(8),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        while (true){

            Socket socket = server.accept();
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());

            pool.execute(new ServerReaderRunnable(socket));//交给线程池来处理

        }

    }

}
