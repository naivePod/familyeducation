package com.lgs.dao;

import com.lgs.entity.EducationInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EducationInformation record);

    int insertSelective(EducationInformation record);

    EducationInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EducationInformation record);

    int updateByPrimaryKeyWithBLOBs(EducationInformation record);

    int updateByPrimaryKey(EducationInformation record);

    List<EducationInformation> selectByCityOrSubject(@Param("city") String city, @Param("subject")String subject);

    List<EducationInformation> selectByName(@Param("name")String name);

    List<EducationInformation> selectExcellent();
}