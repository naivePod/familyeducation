package com.lgs.dao;

import com.lgs.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByTeacherId(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    Teacher selectByUserId(Integer userId);

    List<Teacher> selectByCitySubject(@Param("city") String city, @Param("subject")String subject);

    List<Teacher> selectByName(String username);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKeyWithBLOBs(Teacher record);

    int updateByPrimaryKey(Teacher record);
}