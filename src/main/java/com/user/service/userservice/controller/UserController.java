package com.user.service.userservice.controller;

import com.user.service.userservice.Vo.ResponseTemplateVo;
import com.user.service.userservice.entity.User;
import com.user.service.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        log.info("Inside SaveUser of SaveController");
      return userService.saveUser(user);

    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable ("id") long userId){
        log.info("Inside getUserWithDepartment of SaveController");
      return userService.getUserWithDepartment(userId);
    }



}
