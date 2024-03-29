package com.lgs.dao;

import com.lgs.entity.InsiteMessage;
import com.lgs.vo.MessageVo;

import java.util.List;

public interface InsiteMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsiteMessage record);

    int insertSelective(InsiteMessage record);

    InsiteMessage selectByPrimaryKey(Integer id);

    int selectUnreadMessage(Integer receiverId);

    List<MessageVo>  selectUnreadMessages(Integer receiverId);


    List<MessageVo> selectMessages(Integer receiverId);

    int updateByPrimaryKeySelective(InsiteMessage record);



    int updateByPrimaryKey(InsiteMessage record);
}