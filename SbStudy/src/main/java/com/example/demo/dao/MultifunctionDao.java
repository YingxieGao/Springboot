package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MultifunctionDao {
    Student getStuById(int id);

    List<Student> showAllStu();

    void newStudent(Student student);

    void updateStu(Student student);

    void deleteStu(int id);
}
