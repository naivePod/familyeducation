package com.lgs.service.Impl;

import com.lgs.common.BusinessException;
import com.lgs.common.ServerResponse;
import com.lgs.dao.InsiteMessageMapper;
import com.lgs.dao.InsiteMessageTextMapper;
import com.lgs.entity.InsiteMessage;
import com.lgs.entity.InsiteMessageText;
import com.lgs.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService{
//    @Resource
//    InsiteMessageMapper insiteMessageMapper;
//
//    @Resource
//    InsiteMessageTextMapper insiteMessageTextMapper;
//
//
//    public InsiteMessage getMessage(Integer id) {
//        return insiteMessageMapper.selectByPrimaryKey(id);
//    }
//
//    public ServerResponse postMessageText(InsiteMessageText messageText, List<Integer> toIds) {
//        if(messageText == null || toIds.size() == 0) return ServerResponse.createByError();
//        int row = insiteMessageTextMapper.insert(messageText);
//        if(row == 0) throw new BusinessException(400,"插入失败");
//        int messageId = messageText.getId();
//        for(int id : toIds) {
//            InsiteMessage message = new InsiteMessage();
//            message.setMessageTextId(messageId);
//            message.setReceiverId(id);
//            int res = insiteMessageMapper.insert(message);
//            if(res == 0) throw new BusinessException(400,"插入失败");
//        }
//
//        return ServerResponse.createBySuccess();
//    }

}
