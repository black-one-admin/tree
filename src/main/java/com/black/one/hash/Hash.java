package com.black.one.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 查看hashmap源码
 *
 * @author swh
 * @create: 2020-05-18 17:58
 */
@Slf4j
public class Hash {

    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();

        String put = map.put("key", "value");
        System.out.println("返回结果："+put);
        //使用hashcode计算键，object.当键值为null时设置为0
        //java底层使用native表示java与c联合开发时使用
        int h;
        h = "key".hashCode();
        log.info("String类型计算hashCode:{}",h);
        log.info("Object类型计算hashCode:{}",map.hashCode());
        log.info("字符串0计算hashCode:{}","0".hashCode());
        int n , i;
         i = (0 - 1) & h;
         log.info("计算后得到：{}",i);
        //transient修改，表示序列化对象时该属性或方法不被序列化





    }
}
