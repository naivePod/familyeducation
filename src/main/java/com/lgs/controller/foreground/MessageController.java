package com.lgs.controller.foreground;

import com.lgs.common.ServerResponse;
import com.lgs.entity.InsiteMessageText;
import com.lgs.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/call")
public class MessageController {
    @Autowired
    IMessageService iMessageService;

    @PostMapping("/message")
    public ServerResponse createMessage(InsiteMessageText message) {
        return null;
    }

    @GetMapping("/findunread/{id}")
    public ServerResponse findUnreadMessage(@PathVariable("id") Integer id) {
        return null;
    }
    @GetMapping("/details/{id}")
    public ServerResponse findMessages(@PathVariable("id") Integer id) {
        return null;
    }

    @DeleteMapping("/deleteone/{id}")

    public ServerResponse deleteOne(@PathVariable("id") Integer id) {
        return null;
    }
}
