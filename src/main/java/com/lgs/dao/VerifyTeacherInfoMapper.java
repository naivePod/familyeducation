package com.lgs.dao;

import com.lgs.entity.VerifyTeacherInfo;

public interface VerifyTeacherInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VerifyTeacherInfo record);

    int insertSelective(VerifyTeacherInfo record);

    VerifyTeacherInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VerifyTeacherInfo record);

    int updateByPrimaryKey(VerifyTeacherInfo record);
}