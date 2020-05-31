package com.black.one.weixin.message;

/**
 * 文本回复
 *
 * @author swh
 * @create: 2020-05-31 23:48
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;


@XmlRootElement(name="xml")
public class TextMessage extends BaseMessage {

    private String content;

    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TextMessage(){
        super();
    }

    public TextMessage(Map<String, String> map,String content){
        super(map);
        this.content = content;
    }
}
