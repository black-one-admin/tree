package com.black.one.thread.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 使用多线程查询数据服务层
 *
 * @author swh
 * @create: 2020-05-12 13:48
 */
public interface ThreadService {


    /**
     *多线程查询数据
     * @params
     * @return
     */
    List getSysLogMulti();

    /**
     *使用线程池
     * @params
     * @return
     */
    List threadPooL() throws InterruptedException, ExecutionException;


    String runable();

    /**
     *自定义线程池
     * @params
     * @return
     */
    Object definePool();
}
