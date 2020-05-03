package com.black.one.file.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 表单文件上传
 *
 * @author swh
 * @create: 2020-05-03 16:37
 */
@Data
@ApiModel
public class FileParam {

    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("密码")
    private String password;
}
