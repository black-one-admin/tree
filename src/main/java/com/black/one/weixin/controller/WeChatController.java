package com.black.one.weixin.controller;

import com.black.one.annotations.SystemClassAnnotation;
import com.black.one.weixin.param.WeChatParam;
import com.black.one.weixin.service.WeChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
public class WeChatController {

    @Autowired
    private WeChatService weChatService;


    @ApiOperation("参数接收类")
    @RequestMapping(path = "/param",method = RequestMethod.GET)
    @ResponseBody
    public String param(WeChatParam param){
         return weChatService.param(param);
    }

}
