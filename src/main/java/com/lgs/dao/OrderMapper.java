package com.lgs.dao;

import com.lgs.entity.Order;

import java.util.List;


public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectByTeacherId(Integer teacherId);

    List<Order> selectByStudentId(Integer studentId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}