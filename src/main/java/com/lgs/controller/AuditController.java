package com.lgs.controller;

import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.common.TokenCache;
import com.lgs.entity.Audit;
import com.lgs.entity.User;
import com.lgs.service.IAuditService;
import com.lgs.service.IFileService;
import com.lgs.service.ITeacherService;
import com.lgs.util.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user/audit")
public class AuditController {
    Logger logger = LoggerFactory.getLogger(AuditController.class);
    @Autowired
    IFileService iFileService;

    @Autowired
    IAuditService iAuditService;

    @Autowired
    ITeacherService iTeacherService;

    @RequestMapping("/register.html")
    public String register(Model model, HttpServletRequest request) {
        User user = (User)(request.getSession().getAttribute(Const.CURRENT_USER));
        Audit audit = iAuditService.getAudit(user).getData();
        model.addAttribute("audit",audit);

        return "/user/audit/register.html";
    }
    /**
     * @description: 用户申请成为教师
     * @author: lgs
     * @date:  2019/4/21
     **/
    @PostMapping("/register")
    @ResponseBody
    public ServerResponse regist(Model model, Audit audit, String token_photo, String token_audit, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String uploadName = TokenCache.getKey(token_photo);
        ServerResponse serverResponse = iFileService.upload2FTP(uploadName, path);
        if(!serverResponse.isSuccess()) {
            return serverResponse;
        }
        User user = (User)(request.getSession().getAttribute(Const.CURRENT_USER));
        audit.setUserId(user.getId());
        audit.setPhoto(TokenCache.getKey(token_photo));

        uploadName = TokenCache.getKey(token_audit);
        serverResponse = iFileService.upload2FTP(uploadName, path);
        if(!serverResponse.isSuccess()) {
            return serverResponse;
        }
        audit.setAuditImage(TokenCache.getKey(token_audit));
        audit.setUsername(user.getUsername());
        return iAuditService.addAudit(audit);
    }

    /**
     * @description: 上传图片,生活照
     * @author: lgs
     * @date:  2019/4/21
     **/

    @PostMapping("upload_photo")
    @ResponseBody
    public ServerResponse uploadPhoto(@RequestParam(value = "file", required = false)MultipartFile file,
                                      @RequestParam(value = "token", required = false) String token,
                                      HttpServletRequest request) {
        logger.info("token1{}",token);
        String path = request.getSession().getServletContext().getRealPath("upload");
        String filename = iFileService.upload2WebServer(path, file);
        String filePath = PropertyUtil.getProperty("tomcat.server.http.prefix")+filename;
        Map<String, String> map = new HashMap<>();
        String url_token = UUID.randomUUID().toString();
        map.put("filePathPhoto", filePath);
        map.put("token_photo", url_token);
        logger.info("token{}",url_token);


        TokenCache.setKey(url_token, filename);
        return ServerResponse.createBySuccess(map);
    }

    /**
     * @description: 上传图片,审核照片
     * @author: lgs
     * @date:  2019/4/21
     **/

    @PostMapping("upload_audit_img")
    @ResponseBody
    public ServerResponse uploadAuditImg(@RequestParam(value = "file", required = false)MultipartFile file,
                                         @RequestParam(value = "token", required = false) String token,
                                         HttpServletRequest request) {
        logger.info("token1{}",token);
        String path = request.getSession().getServletContext().getRealPath("upload");
        String filename = iFileService.upload2WebServer(path, file);
        String filePath = PropertyUtil.getProperty("tomcat.server.http.prefix")+filename;
        Map<String, String> map = new HashMap<>();
        String url_token = UUID.randomUUID().toString();
        map.put("filePathAuditImg", filePath);
        map.put("token_audit_img", url_token);
        logger.info("token{}",url_token);


        TokenCache.setKey(url_token, filename);
        return ServerResponse.createBySuccess(map);
    }

    @GetMapping("/information")
    @ResponseBody
    public ServerResponse getAudit(HttpServletRequest request) {
        User user = (User)(request.getSession().getAttribute(Const.CURRENT_USER));
        ServerResponse serverResponse = iAuditService.getAudit(user);
        request.setAttribute("audit", serverResponse.getData());
        return serverResponse;
    }
}
