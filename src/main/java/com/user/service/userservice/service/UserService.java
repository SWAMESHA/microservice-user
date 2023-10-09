package com.user.service.userservice.service;

import com.user.service.userservice.Vo.ResponseTemplateVo;
import com.user.service.userservice.entity.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);

    ResponseTemplateVo getUserWithDepartment(long userId);



}
