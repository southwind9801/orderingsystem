package com.southwind.repository;

import com.southwind.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index,int limit);
}
