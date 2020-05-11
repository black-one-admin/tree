package com.black.one.weixin.service.impl;

import com.black.one.weixin.param.WeChatParam;
import com.black.one.weixin.service.WeChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 微信接口对接实现类
 *
 * @author swh
 * @create: 2020-05-09 09:52
 */
@Service
@Slf4j
@Primary
public class WeChatServiceImpl implements WeChatService {

    @Override
    public String param(WeChatParam param) {
        log.info("echostr:{}",param.getEchostr());
        log.info("signature:{}",param.getSignature());
        log.info("nonce:{}",param.getNonce().toString());
        log.info("timestamp:{}",param.getTimestamp().toString());
        return param.getEchostr();
    }
}
