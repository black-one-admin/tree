package com.black.one.tool;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: 判断是否为空或null
 * @create: 2020-04-06 21:56
 */
public class IsEmptyUtil {

    public static boolean judge(String is){
        if (is == null || is == ""){
            return true;
        }
        return false;
    }
}
