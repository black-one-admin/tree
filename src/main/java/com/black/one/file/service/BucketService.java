package com.black.one.file.service;

import com.black.one.file.param.FileParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 存储空间接口
 *
 * @author swh
 * @create: 2020-05-01 19:30
 */
public interface BucketService {

    /**
     * 创建存储空间oss
     * @author swh
     * @date 2020/5/1
     */
    void mkdir();

    /**
     * 从oss上下载文件
     * @author swh
     * @date 2020/5/3
     */
    void upload()throws Exception;

    /**
     * 获取存储空间列表
     * @author swh
     * @date 2020/5/3
     */
    void listBucket();

    /**
     * @author swh
     * @date 2020/5/3
     * 表单上传
     */
    void form(HttpServletRequest request, FileParam form)throws Exception;
}
