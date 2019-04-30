package com.lgs.dao;

import com.lgs.entity.Audit;

import java.util.List;

public interface AuditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectByPrimaryKey(Integer id);

    Audit selectByUserId(Integer userId);
    List<Audit> selectList();

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);
}