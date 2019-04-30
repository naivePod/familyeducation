package com.lgs.service;

import com.github.pagehelper.PageInfo;
import com.lgs.common.ServerResponse;
import com.lgs.entity.EducationInformation;

import java.util.List;

public interface ITeachInfoService {
    ServerResponse<List<EducationInformation>> getExcellentTeachers();
    ServerResponse<PageInfo<List>> getTeachInfo(String city, String subject, Integer pageNum, Integer pageSize);
    ServerResponse<PageInfo<List>> getTeachInfoByName(String name, Integer pageNum, Integer pageSize);
    ServerResponse addTeachInfo(EducationInformation educationInformation);
}
