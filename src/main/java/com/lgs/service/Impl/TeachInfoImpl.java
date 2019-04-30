package com.lgs.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.common.ServerResponse;
import com.lgs.dao.EducationInformationMapper;
import com.lgs.dao.TeacherMapper;
import com.lgs.entity.EducationInformation;
import com.lgs.entity.Teacher;
import com.lgs.service.ITeachInfoService;
import com.lgs.service.ITeacherService;
import com.lgs.util.PropertyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ITeachInfoService")
public class TeachInfoImpl implements ITeachInfoService {
    @Resource
    EducationInformationMapper educationInformationMapper;

    @Resource
    TeacherMapper teacherMapper;

    public ServerResponse<List<EducationInformation>> getExcellentTeachers() {
        return ServerResponse.createBySuccess(educationInformationMapper.selectExcellent());
    }

    public ServerResponse<PageInfo<List>> getTeachInfo(String city, String subject, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EducationInformation> list = educationInformationMapper.selectByCityOrSubject(city, subject);
        for(EducationInformation educationInformation : list) {
            educationInformation.setPhoto(PropertyUtil.getProperty("ftp.server.http.prefix").trim()+ educationInformation.getPhoto());
        }
        PageInfo<List> pageInfo = new PageInfo(list);
        return ServerResponse.createBySuccess(pageInfo);
    }


    public ServerResponse<PageInfo<List>> getTeachInfoByName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        String like_name = "%" + name + "%";
        List<EducationInformation> list = educationInformationMapper.selectByName(like_name);
        for(EducationInformation educationInformation : list) {
            educationInformation.setPhoto(PropertyUtil.getProperty("ftp.server.http.prefix").trim()+ educationInformation.getPhoto());
        }
        PageInfo<List> pageInfo = new PageInfo(list);
        return ServerResponse.createBySuccess(pageInfo);
    }

    public ServerResponse addTeachInfo(EducationInformation educationInformation) {
        Teacher teacher = teacherMapper.selectByUserId(educationInformation.getUserId());
        educationInformation.setName(teacher.getRealName());
        educationInformation.setPhoto(teacher.getPhoto());
        int row = educationInformationMapper.insertSelective(educationInformation);
        if(row == 0) return ServerResponse.createByError();
        return ServerResponse.createBySuccess();
    }
}
