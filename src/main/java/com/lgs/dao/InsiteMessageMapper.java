package com.lgs.dao;

import com.lgs.entity.InsiteMessage;

public interface InsiteMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsiteMessage record);

    int insertSelective(InsiteMessage record);

    InsiteMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsiteMessage record);

    int updateByPrimaryKey(InsiteMessage record);
}