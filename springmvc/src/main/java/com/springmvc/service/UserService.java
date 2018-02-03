package com.springmvc.service;

import com.springmvc.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

}
