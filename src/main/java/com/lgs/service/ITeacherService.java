package com.lgs.service;

import com.lgs.common.ServerResponse;
import com.lgs.entity.Teacher;

public interface ITeacherService {
    ServerResponse updateTeacher(Teacher teacher);
    ServerResponse addTeacher(Teacher teacher);
    ServerResponse deleteTeacher(Integer teacherId);
}
