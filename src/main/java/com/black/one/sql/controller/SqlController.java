package com.black.one.sql.controller;

import com.black.one.sql.service.SqlService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * sql语句查询
 *
 * @author swh
 * @create: 2020-05-31 17:27
 */
@Controller
@Api(description = "sql语句查询")
@Slf4j
public class SqlController {

    @Autowired
    private SqlService sqlService;
}
