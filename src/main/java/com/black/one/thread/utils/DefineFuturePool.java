package com.black.one.thread.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 线程池有返回值
 *
 * @author swh
 * @create: 2020-05-17 22:03
 */
@Slf4j
public class DefineFuturePool {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCall myCall = new MyCall();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(15),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        log.info("创建线程：{}", t.getName());
                        return t;
                    }
                });
        for (int i = 0; i<10 ; i++){
            Future<String> submit = threadPoolExecutor.submit(myCall);
            String s = submit.get();
            log.info("任务返回结果：{}",s);
        }
        Thread.sleep(5000);


        //关闭线程池，仅仅是不在接收新的任务，以前的任务还会继续执行
        threadPoolExecutor.shutdown();
    }
}
class  MyCall implements Callable<String>{


    @Override
    public String call() throws Exception {
        return "测试成功!";
    }
}
