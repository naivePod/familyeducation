package com.lgs.controller;

import com.lgs.common.BusinessException;
import com.lgs.common.ServerResponse;
import com.lgs.entity.InsiteMessageText;
import com.lgs.entity.User;
import com.lgs.service.IMessageService;
import com.lgs.vo.MessageVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/message")
public class MessageController {
    @Autowired
    IMessageService iMessageService;
    Logger logger = LoggerFactory.getLogger(MessageController.class);
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
    public ServerResponse findUnreadMessageCount() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        int id = user.getId();
        return iMessageService.findUnreadMessageNums(id);
    }
    @GetMapping("/unreadmessages")
    public ServerResponse<List<MessageVo>> findUnreadMessages(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        int id = user.getId();

        return iMessageService.findUnreadMessages(id);
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
