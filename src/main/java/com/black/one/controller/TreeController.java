package com.black.one.controller;


import com.black.one.entity.Region;
import com.black.one.service.TreeService;
import com.black.one.tool.ReturnMessage;
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
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/test")
    public String test(){
        return "测试成功！";
    }

    @GetMapping("/json")
    @ResponseBody
    public ReturnMessage json(){
        String hello = "aaa";
        return ReturnMessage.success("测试成功");
    }


    @GetMapping("/info")
    @ResponseBody
    public ReturnMessage info(){
        List<Region> regionList = treeService.getRegionList();
        return ReturnMessage.success(regionList);
    }
}
