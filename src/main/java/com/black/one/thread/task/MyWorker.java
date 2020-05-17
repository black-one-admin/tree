package com.black.one.thread.task;

import java.util.List;

/**
 * 编写一个线程类，需要继承thread类，设计一个属性，用于保存线程的名字
 *
 * @author swh
 * @create: 2020-05-17 21:06
 */
public class MyWorker extends Thread {

    private String name;

    private List<Runnable> tasks;

    public  MyWorker(String name,List<Runnable> tasks){
        this.name = name;
        this.tasks = tasks;
    }

    @Override
    public void run(){

        //判断集合中是否存在任务，只要有就一直执行
        while(tasks.size()>0){
            Runnable r= tasks.remove(0);
            r.run();
        }
    }
}
