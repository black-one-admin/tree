package com.black.one.sql.service.impl;

import com.black.one.sql.dao.SqlMapper;
import com.black.one.sql.service.SqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author swh
 * @create: 2020-05-31 17:29
 */
@Service
@Primary
@Slf4j
public class SqlServiceImpl implements SqlService {

    @Autowired
    private SqlMapper sqlMapper;
}
