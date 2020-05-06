package com.black.one.file.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.UploadFileRequest;
import com.black.one.file.service.PointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 断点文件上传实现类
 *
 * @author swh
 * @create: 2020-05-04 08:42
 */
@Service
@Primary
@Slf4j
public class PointServiceImpl implements PointService {

    @Value("${endpoint}")
    private String endpoint;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;

    private static final String bucketName = "suwenhai";

    @Override
    public void upload(MultipartFile file) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        ObjectMetadata meta = new ObjectMetadata();
        // 指定上传的内容类型。
        meta.setContentType("text/plain");

        // 通过UploadFileRequest设置多个参数。
        UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName,"<yourObjectName>");

        // 通过UploadFileRequest设置单个参数。
        // 设置存储空间名称。
        //uploadFileRequest.setBucketName("<yourBucketName>");
         // 设置文件名称。
        //uploadFileRequest.setKey("<yourObjectName>");
         // 指定上传的本地文件。
        uploadFileRequest.setUploadFile("<yourLocalFile>");
        // 指定上传并发线程数，默认为1。
        uploadFileRequest.setTaskNum(5);
        // 指定上传的分片大小，范围为100KB~5GB，默认为文件大小/10000。
        uploadFileRequest.setPartSize(1 * 1024 * 1024);
       // 开启断点续传，默认关闭。
        uploadFileRequest.setEnableCheckpoint(true);
        // 记录本地分片上传结果的文件。开启断点续传功能时需要设置此参数，上传过程中的进度信息会保存在该文件中，如果某一分片上传失败，再次上传时会根据文件中记录的点继续上传。上传完成后，该文件会被删除。默认与待上传的本地文件同目录，为uploadFile.ucp。
        uploadFileRequest.setCheckpointFile("<yourCheckpointFile>");
        // 文件的元数据。
        uploadFileRequest.setObjectMetadata(meta);
        // 设置上传成功回调，参数为Callback类型。
        //uploadFileRequest.setCallback("<yourCallbackEvent>");

        // 断点续传上传。
        //ossClient.uploadFile(uploadFileRequest);

        // 关闭OSSClient。
        ossClient.shutdown();

    }
}
