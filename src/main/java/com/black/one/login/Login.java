package com.black.one.login;

/**
 * 登录机制：
 * 1、nginx使用iphash，容易促使某太服务器过载，负载均衡失效
 * 2、session共享 ,集群数量过大是有可能网络延迟
 * 3、redis,第三方存储2
 * 单点登录
 *
 * @author swh
 * @create: 2020-10-25 17:39
 */
public class Login {
}
