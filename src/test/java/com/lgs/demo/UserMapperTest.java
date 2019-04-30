package com.lgs.demo;

import com.lgs.dao.OrderMapper;
import com.lgs.dao.TeacherMapper;
import com.lgs.dao.UserMapper;
import com.lgs.entity.User;
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

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource


    @Test
    public void testInsert() {

    }

}
