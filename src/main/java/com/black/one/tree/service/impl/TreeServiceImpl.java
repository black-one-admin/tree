package com.black.one.tree.service.impl;

import com.black.one.tree.dao.TreeDao;
import com.black.one.tree.entity.Region;
import com.black.one.tree.model.Tree;
import com.black.one.tree.service.TreeService;
import com.black.one.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: 实现类
 * @create: 2020-04-06 19:50
 */
@Service
@Primary
public class TreeServiceImpl implements TreeService {



    @Autowired
    private TreeDao treeDao;
    /**
     * @return
     * @description 获取数区域类型
     * @date 2020/4/6
     * @params
     */
    @Override
    public List<Tree> getRegionList() {
        List<Region> regionList = treeDao.getRegionList();
        List<Tree> tree = TreeUtil.tree(regionList);
        return tree;
    }

    @Override
    public Object map() {
        List<Region> regionList = treeDao.getRegionList();
        Map<String,Object> map= regionList.stream().collect(Collectors.toMap(Region::getRegionguid,Region::getRegionname));
        Map<String,Object> map1= regionList.stream().collect(Collectors.toMap(Region::getRegionguid, res -> res));
        Map<String,Object> map2= regionList.stream().collect(Collectors.toMap(res->res.getRegionguid(), res -> res));
        return map2;
    }

    @Override
    public Object list() {
        Map<String, Region> map = treeDao.getMap();
        //根据值映射
        List<Region> values = map.values().stream().collect(Collectors.toList());
        //根据键映射
        List<String> key = map.keySet().stream().collect(Collectors.toList());

        return values;
    }
}
