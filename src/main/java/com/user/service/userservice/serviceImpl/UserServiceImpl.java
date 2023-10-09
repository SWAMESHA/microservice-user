package com.user.service.userservice.serviceImpl;

import com.user.service.userservice.Vo.Department;
import com.user.service.userservice.Vo.ResponseTemplateVo;
import com.user.service.userservice.entity.User;
import com.user.service.userservice.repository.UserRepository;
import com.user.service.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("Inside SaveUser of UserService");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVo getUserWithDepartment(long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVo responseTemplateVo=new ResponseTemplateVo();
        User user=userRepository.findByUserId(userId);

        Department department=restTemplate.getForObject("http://localhost:8080/api/department/"+ user.getDepartmentId(),Department.class);

        responseTemplateVo.setUser(user);    //above Department object is calling for Department Application.
        responseTemplateVo.setDepartment(department);

        return responseTemplateVo;

    }

}
