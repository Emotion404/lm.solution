package com.springmvc.dao.provider;

import com.springmvc.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserDynaSqlProvider {

    public String saveUser(final User user) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if(user.getName()!=null&&!"".equals(user.getName())){
                    VALUES("name","#{name}");
                }
                if(user.getAge()!=null&&!"".equals(user.getAge())){
                    VALUES("age","#{age}");
                }
                if(user.getSalary()!=null){
                    VALUES("salary","#{salary}");
                }
            }
        }.toString();
    }


}
