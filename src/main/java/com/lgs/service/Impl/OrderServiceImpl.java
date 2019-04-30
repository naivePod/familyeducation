package com.lgs.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.common.BusinessException;
import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.dao.EducationInformationMapper;
import com.lgs.dao.OrderMapper;
import com.lgs.dao.StudentMapper;
import com.lgs.dao.TeacherMapper;
import com.lgs.entity.*;
import com.lgs.service.IMessageService;
import com.lgs.service.IOrderService;
import com.lgs.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("IOrderService")
public class OrderServiceImpl implements IOrderService {
    @Resource
    OrderMapper orderMapper;

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    StudentMapper studentMapper;

    @Resource
    EducationInformationMapper educationInformationMapper;

    @Autowired
    IMessageService iMessageService;

    public ServerResponse createOrder(Order order) {
        order.setStatus((byte) Const.OrderStatusEnum.WAIT_CONFIRM.getCode());
        int row = orderMapper.insertSelective(order);
        if(row == 0) {
            throw new BusinessException(500, "预约失败");
        }
        InsiteMessageText insiteMessageText = new InsiteMessageText();
        insiteMessageText.setTitle("预约通知");
        insiteMessageText.setCreatorId(order.getStudentId());
        //todo manage
        return iMessageService.postMessageText(insiteMessageText,new ArrayList<>(order.getTeacherId()));
    }
    public ServerResponse<PageInfo<List>> getList(User user, Integer pageNum, Integer pageSize) {
        List<Order> list = null;
        if(user.getRole().equals(Const.Role.ROLE_STUDENT)) {
            Student student = studentMapper.selectByUserId(user.getId());
            PageHelper.startPage(pageNum, pageSize);
            list = orderMapper.selectByStudentId(student.getId());
        } else {
            Teacher teacher = teacherMapper.selectByUserId(user.getId());
            PageHelper.startPage(pageNum, pageSize);
            list = orderMapper.selectByStudentId(teacher.getId());
        }
        List orderVoList = toOrderVoList(list);
        PageInfo<List> pageInfo = new PageInfo(list);
        pageInfo.setList(orderVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }
    private List<OrderVo> toOrderVoList(List<Order> orderList) {
        List<OrderVo> list = new ArrayList<>();

        for(Order order : orderList) {
            Teacher teacher = teacherMapper.selectByPrimaryKey(order.getTeacherId());
            Student student = studentMapper.selectByPrimaryKey(order.getStudentId());
            EducationInformation educationInformation = educationInformationMapper.selectByPrimaryKey(order.getEducationInformationId());
            OrderVo orderVo = new OrderVo();
            orderVo.setTeacherName(teacher.getRealName());
            orderVo.setStudentName(student.getSname());
            orderVo.setCreateTime(order.getCreateTime());
            orderVo.setCity(educationInformation.getCity());
            orderVo.setLessonLocation(educationInformation.getLessonLocation());
            orderVo.setLessonTime(educationInformation.getLessonTime());
            orderVo.setStatus(educationInformation.getStatus());
            orderVo.setPrice(educationInformation.getPrice());
            orderVo.setPublishTime(order.getCreateTime());
            list.add(orderVo);
        }
        return list;
    }
    public ServerResponse chageOrderStatus(Integer orderId, byte status) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setStatus(status);
        int row = orderMapper.updateByPrimaryKeySelective(order);
        if(row == 0) return ServerResponse.createByErrorCodeMessage(500,"修改订单状态失败");
        return ServerResponse.createBySuccess();
    }

}
