package com.black.one.weixin.controller;

import com.black.one.annotations.SystemClassAnnotation;
import com.black.one.weixin.exception.AesException;
import com.black.one.weixin.param.WeChatParam;
import com.black.one.weixin.service.WeChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 微信接口测试
 *
 * @author swh
 * @create: 2020-05-09 09:14
 */
@RestController
@RequestMapping("/wechat")
@SystemClassAnnotation
@Api("微信公众号测试接口")
@Slf4j
public class WeChatController {

    @Autowired
    private WeChatService weChatService;


    @ApiOperation("参数接收类")
    @RequestMapping(path = "/param",method = RequestMethod.GET)
    @ResponseBody
    public String param(WeChatParam param)throws AesException {
        return weChatService.param(param);
    }


    @ApiOperation("参数接收类")
    @RequestMapping(path = "/param",method = RequestMethod.POST)
    @ResponseBody
    public void message(HttpServletRequest request, HttpServletResponse response) throws Exception {
       weChatService.message(request, response);
    }


    @ApiOperation("发送请求，获取token")
    @RequestMapping(path = "/token",method = RequestMethod.POST)
    @ResponseBody
    public void token(){

    }
}
