package com.example.usertestdemo.service;

import com.example.usertestdemo.domain.CourseInfo;
import com.example.usertestdemo.dao.UserMapper;
import com.example.usertestdemo.domain.Score;
import com.example.usertestdemo.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public Users selectPrimary(Integer id) throws  Exception {
        return userMapper.selectPrimary(id);
    }

    @Override
    public Integer deletePrimary(Integer id) {
        return userMapper.deletePrimary(id);
    }

    @Override
    public Integer addPrimary(CourseInfo courseInfo) {
        return userMapper.addPrimary(courseInfo);
    }

    public List<Score> oneToMoreQuery(Integer id){
        return userMapper.oneToMoreQuery(id);
    }
}
