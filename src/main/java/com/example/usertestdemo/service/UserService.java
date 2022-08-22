package com.example.usertestdemo.service;


import com.example.usertestdemo.domain.CourseInfo;
import com.example.usertestdemo.domain.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    Users selectPrimary(Integer id) throws Exception;

    Integer deletePrimary(Integer id);

    Integer addPrimary(CourseInfo courseInfo);
}
