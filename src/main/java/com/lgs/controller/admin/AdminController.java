package com.lgs.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lgs.common.ServerResponse;
import com.lgs.entity.Audit;
import com.lgs.service.IAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class AdminController {
    @Autowired
    IAuditService iAuditService;
    @GetMapping("/index")
    public String index() {
        return "redirect:/manage/subject/list";
    }

    @GetMapping("/subject/list")
    public String subjectList(
                          @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                          Model model) {
        model.addAttribute("data", new HashMap());
        return "/manage/manage-subjectBoard.html";
    }

    @GetMapping("/audit/list")
    public String auditList(
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            Model model) {
        ServerResponse<PageInfo> serverResponse = iAuditService.getAuditList(pageSize, pageNum);
        PageInfo pageInfo = serverResponse.getData();
        model.addAttribute("data", pageInfo);
        return "/manage/manage-auditBoard.html";
    }

    @PostMapping("/audit/updateStatus")
    @ResponseBody
    public ServerResponse updateStatus(@RequestParam(name = "id") Integer id,@RequestParam(name = "status") Integer status,Model model) {
        Audit audit = new Audit();
        audit.setId(id);

        ServerResponse serverResponse = iAuditService.updateAuditWithStatus(audit);
        return serverResponse;
    }

}
