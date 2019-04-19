package com.lgs.interceptor;

import com.lgs.common.BusinessException;
import com.lgs.common.ServerResponse;

import org.apache.ibatis.mapping.ResultMap;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BusinessExceptionHandler {


    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public ServerResponse handleShiroException(Exception ex) {
        return ServerResponse.createByError(ex.getMessage());
    }




    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e,HttpServletRequest req){
        ServerResponse r;
        //业务异常
        if(e instanceof BusinessException){
            r = ServerResponse.createByErrorCodeMessage(((BusinessException) e).getCode(),((BusinessException) e).getMsg());
        }else{//系统异常

            r = ServerResponse.createByErrorCodeMessage(500,"未知异常，请联系管理员");
        }

        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = req.getHeader("Content-Type");
        String acceptHeader = req.getHeader("Accept");
        String xRequestedWith = req.getHeader("X-Requested-With");
        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            return r;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", e.getMessage());
            modelAndView.addObject("url", req.getRequestURL());
            modelAndView.addObject("stackTrace", e.getStackTrace());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }


}
