package com.black.one.thread.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author swh
 * @create: 2020-05-12 17:25
 */
@Slf4j
public class MyThread implements Runnable {

    @Override
    public void run() {
        log.info("进入线程Runable!");
    }
}
