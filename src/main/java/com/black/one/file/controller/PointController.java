package com.black.one.file.controller;

import com.black.one.annotations.SystemClassAnnotation;
import com.black.one.file.service.PointService;
import com.black.one.tool.ReturnMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 断点续传
 *
 * @author swh
 * @create: 2020-05-04 08:21
 */
@Controller
@RequestMapping("/break")
@SystemClassAnnotation
@Api("文件断点续传接口")
public class PointController {

    @Autowired
    private PointService service;


    @ApiOperation("获取到断点续传页面")
    @RequestMapping(value = "point",method = RequestMethod.GET)
    public String point(){
        return "point";
    }


    @ApiOperation("获取到断点续传")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public ReturnMessage upload(String fileName){
        //service.upload(file);
        return  ReturnMessage.success("断点上传成功！");
    }
}


