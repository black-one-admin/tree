package com.black.one.utils;

import com.black.one.entity.Region;
import com.black.one.model.Tree;
import com.black.one.tool.IsEmptyUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tree
 * @author: Mr.hws
 * @description: 遍历树工具类
 * @create: 2020-04-06 16:17
 */
public class TreeUtil<T> {

    public static List<Tree> tree(List<Region> list){
      List<Tree> tree = new ArrayList<>();
      Map<String, Region> map = new HashMap<>();
      //查找根节点
       list.stream().forEach(res->map.put(res.getId(),res));
       list.stream().filter(res-> IsEmptyUtil.judge(res.getPid()))
               .forEach(res->{
                   Tree root = new Tree();
                   root.setId(res.getId());
                   root.setName(res.getName());
                   tree.add(root);
               } );
        return tree;
    }


    private static List<Tree> getChild(List<Tree> trees,Map<String, Region> map){
       for (Tree tree : trees){

       }
        return null;
    }
}
