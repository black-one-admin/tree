package com.black.one.service.impl;

import com.black.one.dao.TreeDao;
import com.black.one.entity.Region;
import com.black.one.model.Tree;
import com.black.one.service.TreeService;
import com.black.one.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
