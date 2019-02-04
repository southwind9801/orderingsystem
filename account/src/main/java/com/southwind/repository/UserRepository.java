package com.southwind.repository;

import com.southwind.entity.User;

public interface UserRepository {
    public User login(String username,String password);
}
