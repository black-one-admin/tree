package com.black.one.file.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.black.one.file.FileDao;
import com.black.one.file.entity.Form;
import com.black.one.file.param.FileParam;
import com.black.one.file.service.BucketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 存储空间实现类
 *
 * @author swh
 * @create: 2020-05-01 19:31
 */
@Service
@Primary
@Slf4j
public class BucketServiceImpl implements BucketService {

    @Autowired
    private FileDao dao;

    @Value("${endpoint}")
    private String endpoint;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;

    private static final String bucketName = "suwenhai";


    @Override
    public void mkdir() {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建存储空间。名称
        String name = "hello";
        //要存储的信息
        String content = "Hello OSS";
        ossClient.putObject(bucketName, name, new ByteArrayInputStream(content.getBytes()));
        // 关闭OSSClient。
        ossClient.shutdown();
        log.info("上传文件");
    }

    @Override
    public void upload() throws Exception {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
        OSSObject ossObject = ossClient.getObject(bucketName, "hello");
        // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
        InputStream content = ossObject.getObjectContent();
        if (content != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println("\n" + line);
            }
            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
            content.close();
        }
    }

    @Override
    public void listBucket() {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 列举存储空间。
        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            log.info(" 存储空间：{}", bucket.getName());
        }
        //判断存储空间是否存在
        boolean exists = ossClient.doesBucketExist("yourbucketname");
        log.info("存储空间是否存在{}", exists);
        String location = ossClient.getBucketLocation("suwenhai");
        log.info("存储空间属于那个区域{}", location);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Override
    public void form(HttpServletRequest request, FileParam param) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        MultipartFile file  = fileMap.get("upload");
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        log.info("文件名：{}",originalFilename);
        //获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        log.info(originalFilename+"获取文件后缀：{}",substring);
        //使用uuid作为文件名防止重复
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = uuid+"."+substring;
        File tempFile = File.createTempFile(uuid, substring);
        log.info("重命名文件名称：{}",tempFile);
        //MultipartFile  转换为 File
        file.transferTo(tempFile);
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            //容器不存在，就创建
            if(! ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            String fileHost = "upload";

            //创建文件路径,在bucket空间内
            String fileUrl= fileHost+"/"+fileName;
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, tempFile));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if(null != result){
                log.info("==========>OSS文件上传成功,OSS地址："+fileUrl);
                Form form = new Form();
                form.setId(UUID.randomUUID().toString());
                form.setUpload(fileUrl);
                form.setName(originalFilename);
                dao.insertForm(form);
            }
        }catch (OSSException oe){
            log.error(oe.getMessage());
        }catch (ClientException ce){
            log.error(ce.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭
            ossClient.shutdown();
        }
        deleteFile(tempFile);
    }

    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

   
}
