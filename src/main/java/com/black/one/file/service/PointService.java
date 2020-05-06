package com.black.one.file.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 断点文件上传
 *
 * @author swh
 * @create: 2020-05-04 08:41
 */
public interface PointService {

    void upload(MultipartFile file);
}
