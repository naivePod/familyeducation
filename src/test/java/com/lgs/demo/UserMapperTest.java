package com.lgs.demo;

import com.lgs.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {

    }

}
