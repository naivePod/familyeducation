package com.lgs.service.Impl;

import com.lgs.common.BusinessException;
import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.dao.InsiteMessageMapper;
import com.lgs.dao.InsiteMessageTextMapper;
import com.lgs.dao.UserMapper;
import com.lgs.entity.InsiteMessage;
import com.lgs.entity.InsiteMessageText;
import com.lgs.entity.User;
import com.lgs.service.IMessageService;
import com.lgs.vo.MessageVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin2.message.Message;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("IMessageService")
public class MessageServiceImpl implements IMessageService{
    @Resource
    InsiteMessageMapper insiteMessageMapper;

    @Resource
    InsiteMessageTextMapper insiteMessageTextMapper;

    @Resource
    UserMapper userMapper;


    public ServerResponse getMessage(Integer id) {
        return ServerResponse.createBySuccess(insiteMessageMapper.selectUnreadMessage(id));
    }

    public ServerResponse<List> getAllMessage(Integer id, Integer limit) {
        return ServerResponse.createBySuccess(insiteMessageMapper.selectMessages(id));
    }

    @Transactional(rollbackFor =BusinessException.class)
    public ServerResponse postMessageText(InsiteMessageText messageText, List<Integer> toIds) {
        if(messageText == null || toIds.size() == 0) return ServerResponse.createByError();
        //插入到发送表

        messageText.setDeleted((byte)0);

        int row = insiteMessageTextMapper.insertSelective(messageText);
        if(row == 0) throw new BusinessException(500,"插入失败");

        //插入到接收表
        int messageId = messageText.getId();
        for(int id : toIds) {
            InsiteMessage message = new InsiteMessage();
            message.setMessageTextId(messageId);
            message.setReceiverId(id);
            message.setTake((byte)0);
            message.setDeleted((byte)0);
            message.setReceiverName(userMapper.selectByPrimaryKey(id).getUsername());
            int res = insiteMessageMapper.insertSelective(message);
            if(res == 0) throw new BusinessException(400,"插入失败");
        }

        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse postMessageTextToAdmin(InsiteMessageText messageText) {
        List<User> users = userMapper.selectByRole(Const.Role.ROLE_ADMIN);
        List<Integer> userids = new ArrayList<>();
        for(User user : users) {
            userids.add(user.getId());
        }
        return this.postMessageText(messageText, userids);
    }


    public ServerResponse findUnreadMessageNums(Integer userId) {
        return ServerResponse.createBySuccess(insiteMessageMapper.selectUnreadMessage(userId));
    }

    public ServerResponse<List<MessageVo>> findUnreadMessages(Integer userId) {
        List<MessageVo> list = insiteMessageMapper.selectUnreadMessages(userId);
        for(MessageVo messageVo : list) {
            //更新为已读
            InsiteMessage message = new InsiteMessage();
            message.setId(messageVo.getId());
            message.setTake((byte)1);
            insiteMessageMapper.updateByPrimaryKeySelective(message);
        }
        return ServerResponse.createBySuccess(list);
    }

}
