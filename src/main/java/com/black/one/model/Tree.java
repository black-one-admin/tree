package com.black.one.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: 遍历树
 * @create: 2020-04-06 16:15
 */
@Getter
@Setter
public class Tree {

    private String id;

    private String pid;

    private String name;

    private List<Tree> child;
}
