package com.black.one.thread.service.impl;

import com.black.one.thread.service.ThreadService;
import com.black.one.thread.utils.MyThread;
import com.black.one.thread.utils.TreadCallable;
import com.black.one.tree.dao.TreeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 实现类
 *
 * @author swh
 * @create: 2020-05-12 13:57
 */
@Service
@Primary
@Slf4j
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private TreeDao treeDao;


    @Override
    public List getSysLogMulti() {
        //开始时间
        long start = System.currentTimeMillis();

        //查询数据库总数量
        int count = treeDao.countRegion();
        Callable<List<Object>> call = new TreadCallable(1,3000,"t_region");

        FutureTask<List<Object>> futureTask = new FutureTask<>(call);
        new Thread(futureTask).start();
        List<Object> objects =null;
        try {
            objects = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("查询时间：{}",end-start);
        return objects;
    }

    @Override
    public List threadPooL() throws InterruptedException, ExecutionException{
        int page = 1000;
        //返回结果
        List<Object> result = new ArrayList<>();
        //开始时间
        long start = System.currentTimeMillis();
        //返回结果
        //Callable用于产生结果
        List<Callable<List<Object>>> tasks = new ArrayList<>();
        //查询数据库总数量
        int count = treeDao.countRegion();
        //计算线程数量
        int num = (count%page==0)?count/page:count/page+1;
        for(int i =1 ; i<=num ; i++){
            Callable<List<Object>> call = new TreadCallable(i,page,"t_region");
            tasks.add(call);
        }
        //定义固定长度的线程池  防止线程过多
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        //Future用于获取结果
        //Future用于获取结果
        List<Future<List<Object>>> futures=executorService.invokeAll(tasks);
        //处理线程返回结果
        if(futures!=null&&futures.size()>0){
            for (Future<List<Object>> future:futures){
                result.addAll(future.get());
            }
        }
        executorService.shutdown();//关闭线程池
        long end = System.currentTimeMillis();
        log.info("查询时间：{}",end-start);
        log.info("查询到总数：{}",result.size());
        return result;
    }


    @Override
    public String runable(){
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        return "200";
    }
}
