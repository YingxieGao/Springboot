package com.project.yingxieg.controller;

import com.project.yingxieg.common.aspect.CurrentUser;
import com.project.yingxieg.common.entity.ResultObject;
import com.project.yingxieg.common.entity.Student;
import com.project.yingxieg.common.entity.User;
import com.project.yingxieg.service.MultifunctionService;
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

    @RequestMapping("/index")
    public String page(){
        return "index";
    }
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
    @GetMapping("/get")
    public ResultObject getStuById(String id)
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
    public ResultObject newStudent(@CurrentUser User user, Student student)
    {
        ResultObject resultObject = new ResultObject();
        String uuid = user.getUuid();
        student.setUuid(uuid);
        student.setShoppingCart(uuid);
        resultObject.setData(multifunctionService.newStudent(student));
        return resultObject;
    }

    /**
     * 更新指定学生
     * @param id
     * @param student
     */
    @PutMapping("/update")
    public ResultObject updataStu(String id, Student student)
    {
        ResultObject resultObject = new ResultObject();
        student.setUuid(id);
        multifunctionService.updateStu(student);
        return resultObject;
    }

    /**
     * 删除学生
     * @param id
     */
    @DeleteMapping("/delete")
    public ResultObject deleteStu(String id)
    {
        ResultObject resultObject = new ResultObject();
        resultObject.setData(multifunctionService.deletesStu(id));
        return resultObject;
    }

}
