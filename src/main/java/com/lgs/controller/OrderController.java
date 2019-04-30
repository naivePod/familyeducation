package com.lgs.controller;

import com.github.pagehelper.PageInfo;
import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.entity.Order;
import com.lgs.entity.User;
import com.lgs.service.IOrderService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService iOrderService;

    @PostMapping("/order")
    public ServerResponse order(Model model, Order order) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        //todo 判断user身份
        model.addAttribute(Const.CURRENT_USER, user);
        //todo may 改下面的方法。。暂时
        return iOrderService.createOrder(order);
    }

    @PutMapping("/cancel/{order_id}")
    public ServerResponse cancel(Model model, @PathVariable("order_id") Integer id) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        model.addAttribute(Const.CURRENT_USER, user);

        ServerResponse response = iOrderService.chageOrderStatus(id, Const.OrderStatusEnum.CANCELED.getCode());
        //todo 通知
        if(response.isSuccess()) return ServerResponse.createBySuccessMsg(Const.OrderStatusEnum.CANCELED.getValue());
        return ServerResponse.createByErrorMsg("出现异常");
    }

    @PutMapping("/confirm/{order_id}")
    public ServerResponse confirm(Model model, @PathVariable("order_id") Integer id) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        System.out.println(user);
        model.addAttribute(Const.CURRENT_USER, user);
        ServerResponse response = iOrderService.chageOrderStatus(id, Const.OrderStatusEnum.ORDER_SUCCESS.getCode());
        //todo 通知
        if(response.isSuccess()) return ServerResponse.createBySuccessMsg(Const.OrderStatusEnum.ORDER_SUCCESS.getValue());
        return ServerResponse.createByErrorMsg("出现异常");
    }

    @GetMapping("/list")
    public ServerResponse<PageInfo<List>> list(Model model,
                                               @RequestParam(name="pageNum", defaultValue = "1")Integer pageNum,
                                               @RequestParam(name="pageSize", defaultValue = "20")Integer pageSize,
                                               @RequestParam(name="sort", defaultValue = "")String sort,
                                               @RequestParam(name="sortOrder", defaultValue = "")String sortOrder) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        model.addAttribute(Const.CURRENT_USER, user);
        return iOrderService.getList(user, pageNum, pageSize);
    }
}
