package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{limit}")
    public User findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        UserVO menuVO = new UserVO();
        menuVO.setCode(0);
        menuVO.setMsg("");
        menuVO.setCount(userRepository.count());
        menuVO.setData(userRepository.findAll((page-1)*limit,limit));
        return menuVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody User menu){
        userRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User menu){
        userRepository.update(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }
}
