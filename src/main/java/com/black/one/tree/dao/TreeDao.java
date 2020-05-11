package com.black.one.tree.dao;

import com.black.one.tree.entity.Region;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: dao层
 * @create: 2020-04-06 19:51
 */
public interface TreeDao {

    List<Region> getRegionList();

    @MapKey("regionguid")
    Map<String,Region> getMap();
}
