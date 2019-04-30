package com.lgs.dao;

import com.lgs.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);
}