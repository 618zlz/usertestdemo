package com.example.usertestdemo.dao;


import com.example.usertestdemo.domain.CourseInfo;
import com.example.usertestdemo.domain.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    Users selectPrimary(Integer id);

    Integer deletePrimary(Integer id);

    Integer addPrimary(CourseInfo courseInfo);
}
