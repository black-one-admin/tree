package com.black.one.thread.task;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义线程池，任务类
 *
 * @author swh
 * @create: 2020-05-17 21:01
 */
@Slf4j
public class MyTask implements Runnable {



    @Override
    public void run() {
        String name  =  Thread.currentThread().getName();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程执行完毕！"+Thread.currentThread().getName());
    }

}
