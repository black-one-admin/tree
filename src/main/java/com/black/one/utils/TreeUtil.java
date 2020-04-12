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

    public static List<Tree> tree(List<Region> regions){
        List<Tree> data = new ArrayList<>();
        //先遍历建数据保存到map集合中
        Map<String,Tree> map = new HashMap<>();
        regions.stream().forEach(res->{
            Tree tree = new Tree();
            tree.setId(res.getRegionguid());
            tree.setPid(res.getRegionpguid());
            tree.setName(res.getRegionname());
            map.put(res.getRegionguid(),tree);
            if (IsEmptyUtil.judge(tree.getPid())){
                data.add(tree);
            }
        });
        regions.stream().filter(res ->IsEmptyUtil.judge(res.getRegionpguid()))
                .forEach(
                     res->{System.out.println(res.getRegionguid());}
                 );

        regions.stream().filter(res->res.getRegionpguid()!=null).
                forEach(res->{
                    Tree child = map.get(res.getRegionguid());
                    Tree parent = map.get(res.getRegionpguid());
                    parent.getChild().add(child);
                });

//     for (Region region : regions){
//         if (region.getRegionpguid()!=null){
//             Tree child = map.get(region.getRegionguid());
//             Tree parent = map.get(region.getRegionpguid());
//             parent.getChild().add(child);
//         }
//     }
        return data;
    }
}
