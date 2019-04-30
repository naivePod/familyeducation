package com.lgs.service;

import com.lgs.common.ServerResponse;
import com.lgs.entity.Student;

public interface IStudentService {
    ServerResponse<Student> getStudentInfo(Integer userId);
    ServerResponse updateStudentInfo(Student student);
    ServerResponse addStudent(Student student);
}
