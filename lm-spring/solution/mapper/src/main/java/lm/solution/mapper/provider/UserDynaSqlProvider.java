package lm.solution.mapper.provider;

import lm.solution.pojo.entity.User;
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

    public String updateUser(final User user){
        return  new SQL(){
            {
                UPDATE("user");
                if(user.getName()!=null && !"".equals(user.getName())){
                    SET(" name=#{name} ");
                }
                if(user.getAge()!=null && !"".equals(user.getAge())){
                    SET(" age=#{age} ");
                }
                if(user.getSalary()!=null){
                    SET(" salary=#{salary} ");
                }
                WHERE(" id=#{id} ");
            }
        }.toString();
    }


}
