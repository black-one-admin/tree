package com.black.one.weixin.utils;

import java.util.Map;

/**
 * 自动回复消息
 *
 * @author swh
 * @create: 2020-05-31 23:40
 */
public class MessageUtils {

    public static String refuse(Map<String, String> map){
        switch (map.get("MsgType")){
            case "text":

                break;
            case "image":

                break;
            case "voice":

                break;
            case "video":

                break;
            case "music":

                break;
            case "news":

                break;
            default:

        }
        return null;

    }
}
