package com.lgs.service;

import com.github.pagehelper.PageInfo;
import com.lgs.common.ServerResponse;
import com.lgs.entity.Audit;
import com.lgs.entity.User;

import java.util.List;

public interface IAuditService {
    ServerResponse addAudit(Audit audit);
    ServerResponse<Audit> getAudit(User user);
    ServerResponse<PageInfo> getAuditList(Integer pageSize, Integer pageNum);
    ServerResponse updateAuditWithStatus(Audit audit);
}
