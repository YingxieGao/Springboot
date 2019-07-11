package com.project.yingxieg.dao;

import com.project.yingxieg.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Yingxie Gao
 * @date 2019-07-03 17:03
 */
@Mapper
@Repository
public interface LoginDao {

    boolean signUp(User user);

    boolean login(User user);

    boolean createToken(String username, String userToken);

    boolean logOut(User user);

    boolean checkRepeat(User user);

    boolean checkFirst(User user);
}
