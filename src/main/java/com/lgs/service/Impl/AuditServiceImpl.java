package com.lgs.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.dao.AuditMapper;
import com.lgs.dao.InsiteMessageMapper;
import com.lgs.dao.InsiteMessageTextMapper;
import com.lgs.entity.Audit;
import com.lgs.entity.InsiteMessage;
import com.lgs.entity.InsiteMessageText;
import com.lgs.entity.User;
import com.lgs.service.IAuditService;
import com.lgs.service.IMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("IAuditService")
public class AuditServiceImpl implements IAuditService {
    @Resource
    AuditMapper auditMapper;

    @Resource
    IMessageService iMessageService;

    @Transactional
    public ServerResponse addAudit(Audit audit) {
        int row = auditMapper.insertSelective(audit);
        if(row == 0) return ServerResponse.createByError();
        //todo 审核通知
        InsiteMessageText text = new InsiteMessageText();
        text.setCreatorId(audit.getUserId());
        text.setTitle(Const.Title.TITLE_AUDIT);
        text.setContent("申请家教审核");
        text.setCreatorName(audit.getUsername());
        iMessageService.postMessageTextToAdmin(text);
        return ServerResponse.createBySuccess();
    }

    public ServerResponse<Audit> getAudit(User user) {
        Audit audit = auditMapper.selectByUserId(user.getId());

        return ServerResponse.createBySuccess(audit);
    }

    public ServerResponse<PageInfo> getAuditList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Audit> audits = auditMapper.selectList();
        PageInfo list = new PageInfo(audits);
        return ServerResponse.createBySuccess(list);
    }

    public ServerResponse updateAuditWithStatus(Audit audit) {
        int row = auditMapper.updateByPrimaryKeySelective(audit);
        if(row == 0) return ServerResponse.createByError("更新状态失败");
        return ServerResponse.createBySuccess();
    }
}
