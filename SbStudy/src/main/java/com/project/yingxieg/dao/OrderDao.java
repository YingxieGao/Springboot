package com.project.yingxieg.dao;

import com.project.yingxieg.common.entity.Good;
import com.project.yingxieg.common.entity.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Yingxie Gao
 * @date 2019-07-02 11:18
 */
@Mapper
@Repository
public interface OrderDao {

    boolean addSeller(Seller seller);

    boolean deleteSeller(int id);

    boolean addGood(Good good);

    boolean deleteGood(int id);

    List<Map<String, Object>> showAllGood(int id);

    List<Map<String, Object>> showAllSellers();

    List<Map<String, Object>> showCart(String id);

    boolean addGoodToCart(String id, Good good);

    boolean deleteGoodFromCart(String id, Good good);

    boolean checkOut(String id);
}
