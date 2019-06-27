package com.project.yingxieg.service;

import com.project.yingxieg.dao.MultifunctionDao;
import com.project.yingxieg.common.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultifunctionService {
    @Autowired
    MultifunctionDao multifunctionDao;

    @Cacheable(value = "Student:studentInfo",key = "#id", unless = "#result == null")
    public Student getStuById(String id){
        Student result = multifunctionDao.getStuById(id);
        return result;
    }
    public List<Student> showAllStu() {
        List<Student> result = multifunctionDao.showAllStu();
        return result;
    }
    @CachePut(value = "Student:studentInfo",key = "#student.SId")
    public Student newStudent(Student student) {
        multifunctionDao.newStudent(student);
        return multifunctionDao.getStuById(student.getSId());
    }
    @CachePut(value = "Student:studentInfo",key = "#student.SId")
    public Student updateStu(Student student) {
        multifunctionDao.updateStu(student);
        return multifunctionDao.getStuById(student.getSId());
    }

    @CacheEvict(value = "Student:studentInfo",key = "#id")
    public void deletesStu(String id) {
        multifunctionDao.deleteStu(id);
    }
}
