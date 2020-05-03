package com.black.one.tree.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: 遍历树
 * @create: 2020-04-06 16:15
 */
@Getter
@Setter
@ApiModel
public class Tree {

    @ApiModelProperty("树结构id")
    private String id;
    @ApiModelProperty("树结构pid")
    private String pid;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("子节点信息")
    private List<Tree> child = new ArrayList<>();
}
