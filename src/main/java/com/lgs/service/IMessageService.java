package com.lgs.service;

import com.lgs.common.ServerResponse;
import com.lgs.entity.InsiteMessageText;

import java.util.List;

public interface IMessageService {
    ServerResponse postMessageText(InsiteMessageText messageText, List<Integer> toIds);
    ServerResponse getMessage(Integer id);
    ServerResponse findUnreadMessageNums(Integer userId);
    ServerResponse<List> getAllMessage(Integer id, Integer limit);
}
