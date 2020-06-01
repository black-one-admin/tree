package com.black.one.weixin.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 获取token计算过期时间
 *
 * @author swh
 * @create: 2020-06-01 11:49
 */
@Api("过期时间类")
@Data
@NoArgsConstructor
@ToString
public class AccessToken {

    private String accessToken;
    @ApiModelProperty("过期时间")
    private long expireTime;

    public AccessToken(String accessToken, String expireTime) {
        this.accessToken = accessToken;
        this.expireTime = System.currentTimeMillis()+Integer.parseInt(expireTime)*1000;
    }

    /**
     *判断token是否过期了
     * @params
     * @return
     */
    public boolean isExpired(){
        return System.currentTimeMillis()>expireTime;
    }
}
