package com.black.one.file.controller;

import com.black.one.annotations.SystemClassAnnotation;
import com.black.one.file.param.Param;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件上传
 *
 * @author swh
 * @create: 2020-04-30 17:12
 */
@Controller
@RequestMapping("/view")
@SystemClassAnnotation
@Api("测试文件上传接口")
public class FileController {



    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    @ApiModelProperty("获取上传视图界面")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "upload", value = "页面名称", required = true) })
    public String upload(String upload){
        return upload;
    }

    @RequestMapping(value = "/param",method = RequestMethod.POST)
    @ApiModelProperty("获取上传视图界面")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "body", dataType = "Param", name = "param", value = "信息参数", required = true) })
    public void  param(@RequestBody Param param){

    }


    @RequestMapping(value = "/data",method = RequestMethod.GET)
    @ResponseBody
    @ApiModelProperty("")
    public String data(){
        return "upload";
    }
}
