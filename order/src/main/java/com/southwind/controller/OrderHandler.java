package com.southwind.controller;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(uid,(page-1)*limit,limit));
        return orderVO;
    }

    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid){
        orderRepository.deleteByMid(mid);
    }
}
