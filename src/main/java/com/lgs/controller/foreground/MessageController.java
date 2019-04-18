package com.lgs.controller.foreground;

import com.lgs.common.BusinessException;
import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.entity.InsiteMessageText;
import com.lgs.entity.User;
import com.lgs.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/call")
public class MessageController {
    @Autowired
    IMessageService iMessageService;

    @PostMapping("/message")
    public ServerResponse createMessage(InsiteMessageText message,@RequestParam("toid") Integer toId) {
        List ids = new ArrayList();
        ids.add(toId);
        try {
            iMessageService.postMessageText(message, ids);
        } catch (BusinessException e) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }

    @GetMapping("/findunread")
    public ServerResponse findUnreadMessage(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(Const.CURRENT_USER);
        int id = user.getId();
        return iMessageService.findUnreadMessageNums(id);
    }

    @GetMapping("/allmessages/{id}")
    public ServerResponse findMessages(@PathVariable("id") Integer id,@RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        return null;
    }

    @DeleteMapping("/deleteone/{id}")
    public ServerResponse deleteOne(@PathVariable("id") Integer id) {
        return null;
    }
}
