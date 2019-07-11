package com.project.yingxieg.service;

import com.project.yingxieg.common.entity.User;
import com.project.yingxieg.common.exception.CommonException;
import com.project.yingxieg.common.util.common;
import com.project.yingxieg.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author Yingxie Gao
 * @date 2019-07-03 17:02
 */
@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;

    @Transactional
    public String signUp(User user) {
        boolean isReapeat = loginDao.checkRepeat(user);

        if(!isReapeat){
            String id = common.getUUID();
            user.setUuid(id);
            loginDao.signUp(user);
            return "注册成功！";
        }
        else {
            throw new CommonException("失败，用户名重复。");
        }
    }
    @Transactional
    public String login(User user) {
        boolean isSuccess = loginDao.login(user);
        if(isSuccess){
            String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
            loginDao.createToken(user.getUsername(),token);
            return "登陆成功！";
        }
        else {
            return "登陆失败，账号或密码错误。";
        }
    }

    @Transactional
    public String logOut(User user) {
        loginDao.logOut(user);
        return "退出成功";

    }

    public boolean checkFirst(User user) {
        boolean hasLogin = loginDao.checkFirst(user);
        return !hasLogin;
    }
}
