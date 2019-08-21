package com.project.yingxieg.service;

import com.project.yingxieg.common.entity.Good;
import com.project.yingxieg.common.entity.Seller;
import com.project.yingxieg.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yingxie Gao
 * @date 2019-07-02 11:35
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public Object addSeller(Seller seller) {
        return orderDao.addSeller(seller);
    }

    public Object deleteSeller(int id) {
        return orderDao.deleteSeller(id);
    }

    public Object addGood(Good good) {
        return orderDao.addGood(good);
    }

    public Object deleteGood(int id) {
        return orderDao.deleteGood(id);
    }

    public Object showAllSellers() {
        return orderDao.showAllSellers();
    }

    public Object showAllGoods(int id) {
        return orderDao.showAllGood(id);
    }

    public Object showCart(String id) {
        return orderDao.showCart(id);
    }

    public Object addGoodToCart(String id, Good good) {
        return orderDao.addGoodToCart(id,good);
    }

    public Object deleteGoodFromCart(String id, Good good) {
        return orderDao.deleteGoodFromCart(id,good);
    }

    public Object checkOut(String id) {
        return orderDao.checkOut(id);
    }
}
