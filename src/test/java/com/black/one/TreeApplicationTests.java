package com.black.one;

import com.black.one.sql.dao.SqlMapper;
import com.black.one.sql.entity.TFunction;
import com.black.one.sql.entity.TPost;
import com.black.one.weixin.service.WeChatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeApplicationTests {

    @Autowired
    private SqlMapper sqlMapper;
    @Autowired
    private WeChatService weChatService;

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


    @Test
    public void toekn() {
        weChatService.token();
    }

    @Test
    public void condition(){
        Map<String,String> map = new HashMap<>();
        map.put("postguid", "8a80806a5c7720f3015c7720f35c0000");
        map.put("regionguid", "011");
        List<TPost> condition = sqlMapper.getCondition(map);
        condition.stream().forEach(res-> System.out.println(res.toString()));
    }

}
