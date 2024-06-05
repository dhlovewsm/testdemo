package com.dh.thread.threadpool;

import com.dh.thread.MyCallable;

import java.util.concurrent.*;

public class ThreadPoolTest {


    /**
     * 核心线程数量配置：
     * 计算密集型任务，核心线程数量=CPU的核数 + 1
     * IO密集型的任务：核心线程数量=CPU的核数 * 2
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 创建线程池对象
         */
        ExecutorService pool = new ThreadPoolExecutor(
                //线程池核心线程数量
                3,
                //线程池最大线程数量
                5,
                //临时线程的存活时间
                8,
                //时间单位，时分秒天
                TimeUnit.SECONDS,
                //任务队列
                /*new LinkedBlockingQueue<>() 不限制大小*/
                new ArrayBlockingQueue<>(4),
                //线程工厂
                Executors.defaultThreadFactory(),
                //任务拒绝策略（线程都在忙，任务队列满了，新任务来了该怎么处理）
                new ThreadPoolExecutor.AbortPolicy()
        );

//        Runnable target = new MyRunnable();
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);

//        pool.shutdown();
//        pool.shutdownNow();

        Future<String> f1 = pool.submit(new MyCallable());
        Future<String> f2 = pool.submit(new MyCallable());
        Future<String> f3 = pool.submit(new MyCallable());
        Future<String> f4 = pool.submit(new MyCallable());
        Future<String> f5 = pool.submit(new MyCallable());

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());

    }

}
