package com.black.one.file.controller;

import com.black.one.annotations.SystemClassAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Controller;
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
    public String upload(){
        return "upload";
    }


    @RequestMapping(value = "/data",method = RequestMethod.GET)
    @ResponseBody
    @ApiModelProperty("")
    public String data(){
        return "upload";
    }
}
