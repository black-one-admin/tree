package com.black.one.thread.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 自定义线程池
 * @author swh
 * @create: 2020-05-17 18:53
 */
@Slf4j
public class DefineThreadPoolExecutor implements Runnable{

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + " is runing ,Threadid = " + Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName(), "finish!");
    }

    /**
     *corePoolSize 核心线程 maximumPoolSize最大线程数 keepAliveTime 活跃时间 long类型
     * unit单位时间   workqueue阻塞队列，线程池负载后存放到工作队列等待  threadfactory 线程工厂用于创建线程
     * LinkedBlockingDeque 底层为数组   有界队列，无界队列 。队列要是满就拒绝策略
     * 阻塞队列：永远只能有一个线程能够进行队列的入队或出队操作
     * 队列满只能进行出队操作，所有入队操作必须等待，也就是被阻塞
     * 队列空只能进行入队操作，所有出队操作必须等待，也就是被阻塞
     *
     *
     * 参数执行核心线程满后，先创建workqueue队列 ，后执行最大线程 ，最大空闲时间销毁最大线程中临时线程
     *
     * 饱和机制，就是核心线程最大线程任务队列都满后执行任务  拒绝处理机制
     * @params
     * @return
     */
    public static void main(String[] args) throws InterruptedException {
        DefineThreadPoolExecutor defineThreadPoolExecutor = new DefineThreadPoolExecutor();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        log.info("创建线程：{}", t.getName());
                        return t;
                    }
                });
        for (int i = 0; i<10 ; i++){
            threadPoolExecutor.submit(defineThreadPoolExecutor);
        }
        Thread.sleep(5000);
        threadPoolExecutor.shutdown();

//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }

}
