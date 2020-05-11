package com.black.one.tree.controller;


import com.black.one.annotations.SystemClassAnnotation;
import com.black.one.tool.ReturnMessage;
import com.black.one.tree.model.Tree;
import com.black.one.tree.service.TreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: 树结构
 * @create: 2020-04-06 15:30
 */
@RestController
@RequestMapping("/black/tree")
@SystemClassAnnotation
@Api("树结构")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/test")
    @ApiOperation("测试数据接口")
    public String test(){
        return "测试成功！";
    }

    @GetMapping("/json")
    @ResponseBody
    @ApiOperation("返回值格式设置")
    public ReturnMessage json(){
        String hello = "aaa";
        return ReturnMessage.success("测试成功");
    }


    @GetMapping("/info")
    @ResponseBody
    @ApiOperation("返回树结构")
    public ReturnMessage info(){
        List<Tree> regionList = treeService.getRegionList();
        return ReturnMessage.success(regionList);
    }

    @GetMapping("/map")
    @ResponseBody
    @ApiOperation("将list集合转化为map集合")
    public ReturnMessage map(){
        Object map = treeService.map();
        return ReturnMessage.success(map);
    }

    @GetMapping("/list")
    @ResponseBody
    @ApiOperation("将map集合转化为list集合")
    public ReturnMessage list(){
        Object map = treeService.list();
        return ReturnMessage.success(map);
    }
}
