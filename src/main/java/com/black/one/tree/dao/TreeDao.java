package com.black.one.tree.dao;

import com.black.one.tree.entity.Region;

import java.util.List;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: dao层
 * @create: 2020-04-06 19:51
 */
public interface TreeDao {

    List<Region> getRegionList();
}
