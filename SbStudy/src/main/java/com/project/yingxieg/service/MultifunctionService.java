package com.project.yingxieg.service;

import com.project.yingxieg.common.exception.CommonException;
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

    /**
     * 查学生
     * @param id
     * @return
     */
    @Cacheable(value = "Student:studentInfo",key = "#id", unless = "#result == null")
    public Student getStuById(String id){
        Student result = multifunctionDao.getStuById(id);
        if(result==null) {
            throw new CommonException("查无此人");
        }
        return result;
    }

    /**
     * 显示所有学生
     * @return
     */
    public List<Student> showAllStu() {
        List<Student> result = multifunctionDao.showAllStu();
        return result;
    }

    /**
     * 加学生
     * @param student
     * @return
     */
    @CachePut(value = "Student:studentInfo",key = "#student.uuid")
    public Student newStudent(Student student) {
        multifunctionDao.newStudent(student);
        return multifunctionDao.getStuById(student.getUuid());
    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    @CachePut(value = "Student:studentInfo",key = "#student.uuid")
    public Student updateStu(Student student) {
        multifunctionDao.updateStu(student);
        return multifunctionDao.getStuById(student.getUuid());
    }

    /**
     * 开除学生
     * @param id
     * @return
     */
    @CacheEvict(value = "Student:studentInfo",key = "#id")
    public String deletesStu(String id) {
        if(multifunctionDao.deleteStu(id)){
            return "删除成功";
        }
        return "无此学生";
    }
}
