package com.black.one.thread.controller;

import com.black.one.annotations.SystemClassAnnotation;
import com.black.one.thread.service.ThreadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 使用多线程查询数据
 *
 * @author swh
 * @create: 2020-05-12 13:41
 */
@RestController
@Api("多线程查询数据")
@Slf4j
@RequestMapping("/thread")
@SystemClassAnnotation
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @GetMapping("/getSysLogMulti")
    @ApiOperation(value = "多线程获取日志数据", notes = "多线程获取日志数据", produces = "application/json")
    public List getSysLogMulti() {
        return threadService.getSysLogMulti();
    }

    @GetMapping("/threadPooL")
    @ApiOperation(value = "使用线程池", notes = "使用线程池", produces = "application/json")
    public List threadPooL() throws InterruptedException, ExecutionException{
        List list = threadService.threadPooL();
        return list;
    }

    @GetMapping("/runable")
    @ApiOperation(value = "使用Runable创建线程", notes = "使用Runable创建线程", produces = "application/json")
    public String runable(){
        return threadService.runable();
    }


    @GetMapping("/definePool")
    @ApiOperation(value = "自定义线程池", notes = "自定义线程池", produces = "application/json")
    public Object definePool(){
        return threadService.definePool();
    }
}
