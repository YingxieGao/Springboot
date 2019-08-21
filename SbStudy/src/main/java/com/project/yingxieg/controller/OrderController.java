package com.project.yingxieg.controller;
import com.project.yingxieg.common.entity.Good;
import com.project.yingxieg.common.entity.ResultObject;
import com.project.yingxieg.common.entity.Seller;
import com.project.yingxieg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yingxie Gao
 * @date 2019-07-02 10:25
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/sellers/add")
    public ResultObject addSeller(Seller seller){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.addSeller(seller));
        return resultObject;
    }
    @DeleteMapping("/sellers/{id}")
    public ResultObject deleteSeller(@PathVariable(value="id")int id){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.deleteSeller(id));
        return resultObject;
    }
    @PostMapping("/goods/add")
    public ResultObject addGood(Good good){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.addGood(good));
        return resultObject;
    }
    @DeleteMapping("/goods/{id}")
    public ResultObject deleteGood(@PathVariable(value="id")int id){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.deleteGood(id));
        return resultObject;
    }
    @GetMapping("/sellers")
    public ResultObject showAllSellers(){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.showAllSellers());
        return resultObject;
    }
    @GetMapping("/sellers/{id}/goods")
    public ResultObject showAllGoods(@PathVariable(value = "id")int id){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.showAllGoods(id));
        return resultObject;
    }
    @GetMapping("/cart/{id}")
    public ResultObject showCart(@PathVariable(value = "id") String id){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.showCart(id));
        return resultObject;
    }
    @GetMapping("/cart/{id}/add/{good}")
    public ResultObject addGoodToCart(@PathVariable(value ="id")String id,@PathVariable(value = "good") Good good){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.addGoodToCart(id,good));
        return resultObject;
    }
    @GetMapping("/cart/{id}/delete/{good}")
    public ResultObject deleteGoodFromCart(@PathVariable(value ="id")String id,@PathVariable(value = "good") Good good){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.deleteGoodFromCart(id,good));
        return resultObject;
    }
    @GetMapping("/cart/{id}/checkout")
    public ResultObject checkout(@PathVariable(value ="id")String id){
        ResultObject resultObject = new ResultObject();
        resultObject.setData(orderService.checkOut(id));
        return resultObject;
    }
}
