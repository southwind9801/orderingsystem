package com.southwind.feign;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/menu/findAll")
    public List<Type> findAll();

    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    public void update(@RequestBody Menu menu);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
}
