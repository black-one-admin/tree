package com.black.one.sql.dao;

import com.black.one.sql.entity.TPost;

import java.util.List;

/**
 * dao接口
 *
 * @author swh
 * @create: 2020-05-31 17:32
 */
public interface SqlMapper {


    List<TPost> getRgion();

    /**
     *根据岗位获取菜单栏目
     * @params
     * @return
     */
    TPost getPostInfo();
}
