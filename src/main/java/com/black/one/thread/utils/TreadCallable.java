package com.black.one.thread.utils;

import com.black.one.thread.config.SpringContextUtil;
import com.black.one.tree.dao.TreeDao;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author swh
 * @create: 2020-05-12 14:07
 */
@Slf4j
public class TreadCallable implements Callable<List<Object>> {


    public static SpringContextUtil springContextUtil = new SpringContextUtil();

    private String search;//查询条件 根据条件来定义该类的属性

    private int bindex;//当前页数

    private int num;//每页查询多少条

    private String table;//要查询的表名，也可以写死，也可以从前面传

    private List page;//每次分页查出来的数据

    public  TreadCallable(int bindex,int num,String table) {
        this.bindex=bindex;
        this.num=num;
        this.table=table;
    }

    @Override
    public List call() throws Exception {
        //分页查询数据库数据
        //每个线程查询出来的数据集合
        TreeDao treeDao = springContextUtil.getBean("treeDao");
        page = treeDao.getList((this.bindex-1)*this.num, this.num, this.table);
        log.info("进入Callable线程");
        //返回数据给Future
        return page;
    }


}
