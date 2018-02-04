package com.springmvc.dao;

import com.springmvc.dao.provider.UserDynaSqlProvider;
import com.springmvc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
public interface UserMapper {

    @Select(" select * from user ")
    List<User> findAllUsers();

    @Select(" select * from user where id=#{id} ")
    User findById(long id);

    @Select(" select * from user where name=#{name} ")
    User findByName(String name);

    @InsertProvider(type= UserDynaSqlProvider.class,method = "saveUser")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    Integer saveUser(User user);
}