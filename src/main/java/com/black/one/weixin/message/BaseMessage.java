package com.black.one.weixin.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

/**
 * 信息基础
 *
 * @author swh
 * @create: 2020-05-31 23:44
 */
@Data
@NoArgsConstructor
public class BaseMessage {
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType;

    public BaseMessage(Map<String, String> map){
        this.toUserName = map.get("FromUserName");
        this.fromUserName = map.get("ToUserName");
        this.createTime = map.get("CreateTime");
        this.msgType = map.get("MsgType");
    }
    @XmlElement(name = "ToUserName")
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    @XmlElement(name = "FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
    @XmlElement(name = "CreateTime")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    @XmlElement(name = "MsgType")
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
