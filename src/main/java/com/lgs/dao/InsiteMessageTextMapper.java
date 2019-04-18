package com.lgs.dao;

import com.lgs.entity.InsiteMessageText;

public interface InsiteMessageTextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsiteMessageText record);

    int insertSelective(InsiteMessageText record);

    InsiteMessageText selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsiteMessageText record);

    int updateByPrimaryKeyWithBLOBs(InsiteMessageText record);

    int updateByPrimaryKey(InsiteMessageText record);
}