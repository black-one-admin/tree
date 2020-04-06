package com.black.one.tool;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: 结果参数
 * @create: 2020-04-06 15:44
 */
@Getter
@Setter
public class ReturnMessage {

    private String msg;

    private Object data;


    private ReturnMessage(Object data){
        this.msg = "200";
        this.data = data;
    }

    private ReturnMessage(String msg,Object data){
        this.msg = msg;
        this.data = data;
    }


    public static ReturnMessage  success(Object data){
        return new ReturnMessage(data);
    }

    public static ReturnMessage fail(String msg,Object data){
        return new ReturnMessage(msg,data);
    }
}
