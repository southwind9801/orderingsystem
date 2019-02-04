package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/findAll/{page}/{limit}")
    public List<Menu> findAll(@PathVariable("page") int page,@PathVariable("limit") int limit){
        return menuRepository.findAll((page-1)*limit,limit);
    }
}
