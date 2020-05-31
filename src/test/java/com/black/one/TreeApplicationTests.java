package com.black.one;

import com.black.one.sql.dao.SqlMapper;
import com.black.one.sql.entity.TFunction;
import com.black.one.sql.entity.TPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeApplicationTests {

    @Autowired
    private SqlMapper sqlMapper;

    @Test
    public void contextLoads() {
        List<TPost> rgion = sqlMapper.getRgion();
        rgion.stream().forEach(res ->{
            System.out.println("测试resultmap"+res.toString());
        });
    }

    @Test
    public void info(){
        TPost postInfo = sqlMapper.getPostInfo();
        List<TFunction> tFunctions = postInfo.getTFunctions();
//        tFunctions.stream().forEach(res -> {
//            System.out.println("=================");
//            System.out.println(res.toString());
//        });
        System.out.println("为转化时map集合大小"+tFunctions.size());

        Map<String, TFunction> collect = tFunctions.stream().filter(res -> res.getFunid().length() == 5)
                .collect(Collectors.toMap(TFunction::getFunid, res -> res));

        System.out.println("转化后map集合大小"+collect.size());


    }
}
