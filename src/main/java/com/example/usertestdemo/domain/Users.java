package com.example.usertestdemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Users {
    private Integer id;
    private String name;
    private String password;
    private List<Score> scores;
}
