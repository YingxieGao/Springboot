package com.example.demo.service;

import com.example.demo.dao.MultifunctionDao;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultifunctionService {
    @Autowired
    MultifunctionDao multifunctionDao;

    public Student getStuById(int id){
        Student result = multifunctionDao.getStuById(id);
        return result;
    }

    public List<Student> showAllStu() {
        List<Student> result = multifunctionDao.showAllStu();
        return result;
    }

    public void newStudent(Student student) {
        multifunctionDao.newStudent(student);
    }

    public void updateStu(Student student) {
        multifunctionDao.updateStu(student);
    }

    public void deletesStu(int id) {
        multifunctionDao.deleteStu(id);
    }
}
