package com.southwind.repository;

import com.southwind.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index, int limit);
    public int count();
    public void save(User menu);
    public User findById(long id);
    public void update(User menu);
    public void deleteById(long id);
}
