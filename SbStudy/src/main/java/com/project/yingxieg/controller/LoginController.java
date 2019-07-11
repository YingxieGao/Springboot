package com.project.yingxieg.controller;

import com.project.yingxieg.common.aspect.CurrentUser;
import com.project.yingxieg.common.entity.ResultObject;
import com.project.yingxieg.common.entity.User;
import com.project.yingxieg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yingxie Gao
 * @date 2019-07-03 17:02
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public ResultObject signUp(User user){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(loginService.signUp(user));
        return resultObject;

    }

    @GetMapping("/login")
    public ResultObject login(User user){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(loginService.login(user));
        return resultObject;
    }

    @GetMapping("/checkfirst")
    public ResultObject checkFirst(@CurrentUser User user)
    {
        ResultObject resultObject = new ResultObject();
        resultObject.setData(loginService.checkFirst(user));
        return resultObject;
    }

    @GetMapping("/logout")
    public ResultObject logOut(@CurrentUser User user){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(loginService.logOut(user));
        return resultObject;
    }


}
