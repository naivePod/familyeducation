package com.lgs.dao;

import com.lgs.entity.TeachInformation;

public interface TeachInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeachInformation record);

    int insertSelective(TeachInformation record);

    TeachInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeachInformation record);

    int updateByPrimaryKeyWithBLOBs(TeachInformation record);

    int updateByPrimaryKey(TeachInformation record);
}