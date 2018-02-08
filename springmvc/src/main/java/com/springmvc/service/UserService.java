package com.springmvc.service;

import com.springmvc.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findById(long id);

    boolean isUserExist(User user);

    void saveUser(User user);

    void updateUser(User user);

}
