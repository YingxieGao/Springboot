package com.project.yingxieg.dao;

import com.project.yingxieg.common.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MultifunctionDao {
    Student getStuById(String id);

    List<Student> showAllStu();

    void newStudent(Student student);

    void updateStu(Student student);

    void deleteStu(String id);
}
