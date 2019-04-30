package com.lgs.service.Impl;

import com.lgs.common.ServerResponse;
import com.lgs.dao.TeacherMapper;
import com.lgs.entity.Teacher;
import com.lgs.service.ITeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ITeacherService")
public class TeacherServiceImpl implements ITeacherService {
    @Resource
    TeacherMapper teacherMapper;

    public ServerResponse getTeachers() {
        return null;
    }

    public ServerResponse updateTeacher(Teacher teacher) {
        int row = teacherMapper.updateByPrimaryKeySelective(teacher);
        if(row == 0) return ServerResponse.createByError();
        return ServerResponse.createBySuccess();
    }

    public ServerResponse addTeacher(Teacher teacher) {
        int row = teacherMapper.insertSelective(teacher);
        if(row == 0) return ServerResponse.createByError();
        return ServerResponse.createBySuccess();
    }

    public ServerResponse deleteTeacher(Integer teacherId) {
        return null;
    }
}
