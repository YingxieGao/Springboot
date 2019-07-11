package com.project.yingxieg.common.service;

import com.project.yingxieg.common.dao.CommonDao;
import com.project.yingxieg.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yingxie Gao
 * @date 2019-07-08 14:00
 */
@Service
public class CommonService {
    @Autowired
    private CommonDao commonDao;

    public User findByToken(String token){
        User user = commonDao.findByToken(token);
        return user;
    }
}
