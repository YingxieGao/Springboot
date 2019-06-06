package com.example.demo.controller;

import com.example.demo.entity.ResultObject;
import com.example.demo.entity.Student;
import com.example.demo.service.MultifunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @Author: yingxieg
 * @Description:
 * @Date: 2019-06-06
 */

@RestController
@RequestMapping("/test")


public class MultifuctionController {
    @Autowired
    private MultifunctionService multifunctionService;

    /**
     * 查看当先所有学生信息
     * @return
     */
    @GetMapping("/show")
    public ResultObject showAllStu()
    {
        ResultObject resultObject = new ResultObject();
        resultObject.setData(multifunctionService.showAllStu());
        return resultObject;
    }

    /**
     * 根据id获取学生信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public ResultObject getStuById(@PathVariable(value="id") int id)
    {
        ResultObject resultObject = new ResultObject();
        resultObject.setData(multifunctionService.getStuById(id));
        return resultObject;
    }

    /**
     * 创建学生
     * @param student
     */
    @PostMapping("/add")
    public void newStudent(Student student)
    {
        multifunctionService.newStudent(student);
    }

    /**
     * 更新指定学生
     * @param id
     * @param student
     */
    @PutMapping("update/{id}")
    public void updataStu(@PathVariable(value = "id") int id, Student student)
    {
        student.setSId(id);
        multifunctionService.updateStu(student);
    }

    /**
     * 删除学生
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteStu(@PathVariable(value = "id") int id)
    {
        multifunctionService.deletesStu(id);
    }

}
