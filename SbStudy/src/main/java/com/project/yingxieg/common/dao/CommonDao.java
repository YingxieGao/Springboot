package com.project.yingxieg.common.dao;

import com.project.yingxieg.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Yingxie Gao
 * @date 2019-07-08 14:05
 */
@Mapper
@Repository
public interface CommonDao {
    User findByToken(String token);
}
