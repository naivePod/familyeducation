package com.lgs.controller;

import com.lgs.common.BusinessException;
import com.lgs.common.ServerResponse;
import com.lgs.entity.InsiteMessageText;
import com.lgs.entity.User;
import com.lgs.service.IMessageService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/communication")
public class MessageController {
    @Autowired
    IMessageService iMessageService;

    @PostMapping("/message")
    public ServerResponse createMessage(InsiteMessageText message,@RequestParam("toid") Integer toId) {
        List ids = new ArrayList();
        ids.add(toId);
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        message.setCreatorId(user.getId());
        message.setCreatorName(user.getUsername());
        try {
            iMessageService.postMessageText(message, ids);
        } catch (BusinessException e) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }

    @GetMapping("/findunread")
    public ServerResponse findUnreadMessage() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        int id = user.getId();
        return iMessageService.findUnreadMessageNums(id);
    }

    @GetMapping("/allmessages")
    public ServerResponse<List> findMessages(@RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        int id = user.getId();
        return iMessageService.getAllMessage(id, limit);
    }

    @DeleteMapping("/deleteone/{id}")
    public ServerResponse deleteOne(@PathVariable("id") Integer id) {
        return null;
    }

    @PutMapping("/read_messages")
    public ServerResponse readMessages(@PathVariable("id") Integer id) {
        return null;
    }
}
