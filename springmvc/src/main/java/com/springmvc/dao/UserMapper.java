package com.springmvc.dao;

import com.springmvc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMapper {

    @Select(" select * from user ")
    List<User> findAllUsers();

}