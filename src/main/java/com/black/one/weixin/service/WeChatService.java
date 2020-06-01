package com.black.one.weixin.service;

import com.black.one.weixin.exception.AesException;
import com.black.one.weixin.param.WeChatParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 微信接口service
 *
 * @author swh
 * @create: 2020-05-09 09:22
 */
public interface WeChatService {

    String param(WeChatParam param)throws AesException;

   void message(HttpServletRequest request, HttpServletResponse response) throws Exception;

   /**
    *获取access_token
    * @params
    * @return
    */
   void token();
}
