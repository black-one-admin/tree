package com.black.one.thread.task;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义线程池类
 *
 * @author swh
 * @create: 2020-05-17 21:12
 */
public class MyThreadPool {

    //任务队列  集合  需要控制线程安全问题
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());

    //当前线程数量
    private int num;

    //核心线程数量
    private int corePoolSize;

    //最大线程数量
    private int maxSize;

    //任务队列的长度
    private int workSize;



    public MyThreadPool( int corePoolSize, int maxSize, int workSize) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.workSize = workSize;
    }

    /**
     *提交任务
     * @params
     * @return
     */
    public  void submit(Runnable r){
        //判断当前集合中任务的数量，是否超出了最大任务数量

        if (tasks.size()>=workSize){
            System.out.println("任务："+r+"被丢弃");
        }else{
            tasks.add(r);
            //执行任务
            this.execTask(r);
        }
    }

    /**
     *执行任务
     * @params
     * @return
     */
    public void execTask(Runnable r){
        //判断当前线程池中的线程总数量，是否超出核心线程数
        if (num < corePoolSize){
            new MyWorker("核心线程"+ num,tasks).start();
            num++;
        }else if (num<maxSize){
            new MyWorker("非核心线程"+ num,tasks).start();
            num++;
        }else{
            System.out.println("任务："+r+"被缓存起来了");
        }
    }
}
