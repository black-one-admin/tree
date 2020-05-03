package com.black.one.file.controller;

import com.black.one.annotations.SystemClassAnnotation;
import com.black.one.file.param.FileParam;
import com.black.one.file.service.BucketService;
import com.black.one.tool.ReturnMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * oss存储空间bucket
 *
 * @author swh
 * @create: 2020-05-01 19:24
 */
@SystemClassAnnotation
@Controller
@RequestMapping("/bucket")
@Api("存储空间")
public class BucketController {

    @Autowired
    private BucketService bucketService;

    @ApiOperation("简单文件上传")
    @RequestMapping(path = "/mkdir",method = RequestMethod.GET)
    @ResponseBody
    public ReturnMessage mkdri(){
        bucketService.mkdir();
        return ReturnMessage.success("创建成功！");
    }

    @ApiOperation("简单文件下载")
    @RequestMapping(path = "/upload",method = RequestMethod.GET)
    @ResponseBody
    public ReturnMessage upload()throws Exception{
        bucketService.upload();
        return ReturnMessage.success("从oss下载文件！");
    }

    @ApiOperation("获取存储空间列表")
    @RequestMapping(path = "/listBucket",method = RequestMethod.GET)
    @ResponseBody
    public ReturnMessage listBucket(){
        bucketService.listBucket();
        return ReturnMessage.success("获取存储空间列表");
    }

    @ApiOperation("表单上传页面")
    @RequestMapping(path = "/formup",method = RequestMethod.GET)
    public String formup(){
        return "form";
    }

    @ApiOperation("表单上传")
    @RequestMapping(path = "/form",method = RequestMethod.POST)
    @ResponseBody
    public ReturnMessage form(HttpServletRequest request, FileParam form)throws Exception{
        bucketService.form(request, form);
        return ReturnMessage.success("表单上传");
    }
}
