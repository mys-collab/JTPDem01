package com.jtp7.demo.controller;

import com.jtp7.demo.entity.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class SercurityTestController {

    @GetMapping("hello")
    public String hello() {
        return "hello security";
    }

    @Secured({"ROLE_finance","ROLE_manager","ROLE_driver"})
    @GetMapping("index")
    public String index() {
        return "hello index";
    }

    @GetMapping("update")
    @Secured({"ROLE_manager","ROLE_driver"})
    public String update() {
        System.out.println("update......");
        return "hello update";
    }
    @Secured({"ROLE_manager"})
    @GetMapping("getAll")
    public List<Users> getAllUser(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(11,"admin1","6666",0));
        list.add(new Users(21,"admin2","888",0));
        System.out.println(list);
        return list;
    }
//    @PreAuthorize("hasAnyAuthority('admins')")
//    @PostAuthorize("hasAnyAuthority('admins')")
//    @PostFilter("filterObject.username == 'admin1'")返回时过滤掉不符合条件的数据
//    @PerFilter传入时过滤掉不符合条件的数据
}
