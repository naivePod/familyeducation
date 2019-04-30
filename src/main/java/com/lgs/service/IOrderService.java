package com.lgs.service;

import com.github.pagehelper.PageInfo;
import com.lgs.common.ServerResponse;
import com.lgs.entity.Order;
import com.lgs.entity.User;

import java.util.List;

public interface IOrderService {
    ServerResponse createOrder(Order order);
    ServerResponse<PageInfo<List>> getList(User user, Integer pageNum, Integer pageSize);
    ServerResponse chageOrderStatus(Integer orderId, byte status);
}
