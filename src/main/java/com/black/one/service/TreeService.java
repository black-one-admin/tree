package com.black.one.service;

import com.black.one.entity.Region;
import com.black.one.model.Tree;

import java.util.List;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: service接口，关于树
 * @create: 2020-04-06 19:49
 */
public interface TreeService {

    /**
     * @description 获取数区域类型
     * @date 2020/4/6
     * @params
     * @return
     */
    List<Tree> getRegionList();
}
