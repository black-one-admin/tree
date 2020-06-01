package com.black.one.zhifu;

import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayOpenOperationOpenbizmockBizQueryModel;
import com.alipay.api.request.AlipayOpenOperationOpenbizmockBizQueryRequest;
import com.alipay.api.response.AlipayOpenOperationOpenbizmockBizQueryResponse;

/**
 * 支付宝SDK测试接口
 *
 * @author swh
 * @create: 2020-06-01 15:04
 */
public class Main {

    public static void main(String[] args) {
        try {
            // 1. 创建AlipayClient实例
            AlipayClient alipayClient = new DefaultAlipayClient(getClientParams());
            // 2. 创建使用的Open API对应的Request请求对象
            AlipayOpenOperationOpenbizmockBizQueryRequest request = getRequest();
            // 3. 发起请求并处理响应
            AlipayOpenOperationOpenbizmockBizQueryResponse response = alipayClient.certificateExecute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功。");
            } else {
                System.out.println("调用失败，原因：" + response.getMsg() + "，" + response.getSubMsg());
            }
        } catch (Exception e) {
            System.out.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static CertAlipayRequest getClientParams() {
        CertAlipayRequest certParams = new CertAlipayRequest();
        certParams.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        //请更换为您的AppId
        certParams.setAppId("2016102200735442");
        //请更换为您的PKCS8格式的应用私钥
        certParams.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCyto4zAHmvmVgk5zb0p1wouSA5+4TG4MAq1VurTwV/hlCId50IjD/MmgVL8N9ujEk+dYsuUTaN7uBLPPIa5j52TkyrXnmzgUVWwCJ61uKOixQzbxP/idAyRO9qKfBoiZjMa8X2KptaoIyqub66Rweehu8/gUnXvmmeJp/GsMnaRCWjTo2eJzBruzlCG0YCpe/W3u3xXCbcYmjiLoQHkSvLsY51/S0G+ku5Xpi+gCWAAOnr5Y3igPWxiwBCcMc22ka5mjZxZIUKafEB8e6IzXYGGiSEGFq5jX1Phr/IUd7W27EyQXCMgJ1k98gKGrBYmkw6YPtFxLF/5CMgFxBKKZ+5AgMBAAECggEANcnGQMl61oQzyF+i5b3dehBGB82Q5/7LN9khjwzonbpCUOCXbfQwW5db0sB7rx0gCmF8c4NUBSIJdfuw7rGvyRHF96omvQVCZlrLxecZJ0fq25QqE7ZZ6FdhK7XVutD3IUeqvG2UdpFt5RCkvBIW0/rO1XFHVVzlEwmS+01IY52wQfAtCI3kA6YOgs8hk1eugu+MIYQFtyQyALKHKbQa2vMMsmsweDLbz6mQd8FNnuhx2FdDnTAyI2gKAtg47VaNXYq4UQXXIBTSfwWGos1vt5L3bljJJnKWsnVgmU/KA4+72t48JVUNfsI8nIMz2yForCQVf5ZQsM1C1Yzh1a/a1QKBgQDgj18jYbT+UIN28YPN3u5vjgFlmoJ/YvfvDq/aZfIoRr2sPsioUaCkfyqBSdngUdvUu0ZkPKW+cKIK9GMMlrFC5iE2blgvwoZuM0WYTdtTACiXwX3sP2VO6UA1hVOaH0LGNeGJdrHZLf3BrumlbZ3QvbrYl57/epO6IBMy4/RvwwKBgQDLu/LayezZA+UE8qvXKV8/4KXKDGC7HxztgScPU9Z59cM7ZcKlmo70oxcpNL8efR4ucuNna2C74rJ0zoY5U7X9olXKlTxGC4100Y3a2lIAfMdEFvkuSF//7E2WLhEihwJgG8tWkA/oVhOWa5lH4ukEalo9/b8cLtiFGdHn4OJW0wKBgQDcZntnG6fsD5PocwT9U3fMT6E5WtwIMVfM7ypT/ckeFMhmvTxuT6eOrC1ItfY8/7r2YVSmXwwCDURN4i0xFtomIf6pEMZHIfKVSIdfA9Nm9Hni8IsqC9LgD3jwzsoOM+5y4kFZjQDjewtbRNSXhC3nycAQg0gP0fwaKw8M3MV1xwKBgFh98IRbxMaWTHmTtlQkojyqpRhXvARLBVOcD402yyf6OaypDJzFv2Y/GKZLROBHVD60pFWdbEzvsLfPpLltxNTAGCeAHsgF6JFfHBB9V7TifeLzX5Rc12XgC+s5YzPuFHgOWonk1SQDj0p8vf1db/z8/OmEN+hT6LQXfPcM1QMFAoGAIxjkno3TvYUYuRGGcTPPcCe3+xP9lo45qSIdM8JQZMV/CWMuZJYY3C6V4+/vwzr61ARNBh+zcVJh+psMUvgw6S5nbEmzvwfQrymZV0WGzNXmY3vmS3KfiyLlrRALQSn0MM3EfD7hxp2bj1uJisl4jnrCGXSoHntPxjo3A6/b5PY=");
        //请更换为您使用的字符集编码，推荐采用utf-8
        certParams.setCharset("utf-8");
        certParams.setFormat("json");
        certParams.setSignType("RSA2");
        //请更换为您的应用公钥证书文件路径
        certParams.setCertPath("/home/foo/appCertPublicKey_2019091767145019.crt");
        //请更换您的支付宝公钥证书文件路径
        certParams.setAlipayPublicCertPath("/home/foo/alipayCertPublicKey_RSA2.crt");
        //更换为支付宝根证书文件路径
        certParams.setRootCertPath("/home/foo/alipayRootCert.crt");
        return certParams;
    }

    private static AlipayOpenOperationOpenbizmockBizQueryRequest getRequest() {
        // 初始化Request，并填充Model属性。实际调用时请替换为您想要使用的API对应的Request对象。
        AlipayOpenOperationOpenbizmockBizQueryRequest request = new AlipayOpenOperationOpenbizmockBizQueryRequest();
        AlipayOpenOperationOpenbizmockBizQueryModel model = new AlipayOpenOperationOpenbizmockBizQueryModel();
        model.setBizNo("test");
        request.setBizModel(model);
        return request;
    }
}
