package com.southwind.repository;

import com.southwind.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);
    public List<Order> findAllByUid(long uid,int index,int limit);
    public int countByUid(long uid);
    public void deleteByMid(long mid);
}
