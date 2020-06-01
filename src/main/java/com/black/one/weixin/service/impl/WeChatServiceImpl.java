package com.black.one.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.black.one.weixin.exception.AesException;
import com.black.one.weixin.message.TextMessage;
import com.black.one.weixin.param.WeChatParam;
import com.black.one.weixin.pojo.AccessToken;
import com.black.one.weixin.service.WeChatService;
import com.black.one.weixin.utils.ParseXml;
import com.black.one.weixin.utils.SignUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Map;

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

    @Autowired
    private RestTemplate restTemplate;
    @Value("${weixin.granttype}")
    private String granttype;
    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;
    @Value("${weixin.url}")
    private String url;

    @SneakyThrows
    @Override
    public String param(WeChatParam param) throws AesException {
        log.info("echostr:{}",param.getEchostr());
        log.info("signature:{}",param.getSignature());
        log.info("nonce:{}",param.getNonce());
        log.info("timestamp:{}",param.getTimestamp());
        if (SignUtil.checkSignature(param.getSignature(),param.getTimestamp(), param.getNonce())){
            return param.getEchostr();
        }
        throw new AesException(AesException.ValidateSignatureError);
    }

    @Override
    public void message(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map map = ParseXml.parseXml(request);
        map.forEach((key,value)->{
            System.out.println("键:"+key+" 值:"+value);
        });
        response.setCharacterEncoding("utf-8");
        //String str ="<xml><ToUserName><![CDATA["+map.get("FromUserName")+"]]></ToUserName><FromUserName><![CDATA["+map.get("ToUserName")+"]]></FromUserName><CreateTime>"+map.get("CreateTime")+"</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[谢谢你关注我]]></Content></xml>";
        // 利用jdk中自带的转换类实现
        TextMessage textMessage = new TextMessage(map,"黑一公众号");
        JAXBContext context = JAXBContext.newInstance(textMessage.getClass());
        Marshaller marshaller = context.createMarshaller();
        // 设置编码字符集
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        // 格式化XML输出，有分行和缩进
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(textMessage, baos);
        // 生成XML字符串
        String xmlObj = new String(baos.toByteArray());

        System.out.println(xmlObj);
        PrintWriter out = response.getWriter();
        out.print(xmlObj);
        out.close();
    }


    @Override
    public void token() {
        //HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        // String personResultAsJsonStr = restTemplate.postForObject(createPersonUrl, request, String.class);

        this.url = this.url+"?grant_type="+granttype+"&appid="+appid+"&secret="+secret;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url,String.class);
        System.out.println(forEntity);
        JSONObject jsonObject = JSON.parseObject(forEntity.getBody());
        System.out.println("返回值："+jsonObject.getString("access_token"));
        System.out.println("返回值："+jsonObject.getString("expires_in"));
        AccessToken accessToken = new AccessToken(jsonObject.getString("access_token"), jsonObject.getString("expires_in"));
        log.info("过期时间计算"+accessToken.toString());
    }
}
