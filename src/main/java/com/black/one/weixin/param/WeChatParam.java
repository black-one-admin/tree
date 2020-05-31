package com.black.one.weixin.param;

import lombok.Data;

/**
 * 信服务器将发送GET请求,参数接收类
 *
 * @author swh
 * @create: 2020-05-09 09:16
 */
@Data
public class WeChatParam {

    private String signature;

    private String timestamp;

    private String nonce;

    private String echostr;
}
