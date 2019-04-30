package com.lgs.service.Impl;

import com.lgs.common.ServerResponse;
import com.lgs.dao.StudentMapper;
import com.lgs.entity.Student;
import com.lgs.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("IStudentService")
public class StudentServiceImpl implements IStudentService {
    @Resource
    StudentMapper studentMapper;

    public ServerResponse<Student> getStudentInfo(Integer userId) {
        Student student = studentMapper.selectByUserId(userId);
        if(student == null) {
            return ServerResponse.createByErrorMsg("需要登记学生档案");
        }
        return ServerResponse.createBySuccess(student);
    }

    public ServerResponse updateStudentInfo(Student student) {
        int row = studentMapper.updateByPrimaryKeySelective(student);
        if(row == 0) return ServerResponse.createBySuccessMsg("修改失败");
        return ServerResponse.createBySuccess();
    }

    public ServerResponse addStudent(Student student) {
        int row = studentMapper.insertSelective(student);
        if(row == 0) return ServerResponse.createBySuccessMsg("添加学生档案失败");
        return ServerResponse.createBySuccess();
    }
}
