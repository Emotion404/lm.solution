package lm.solution.mapper;

import lm.solution.pojo.entity.User;
import lm.solution.mapper.provider.UserDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @UpdateProvider(type = UserDynaSqlProvider.class,method = "updateUser")
    Integer updateUser(User user);

    @Delete(" delete from user where id=#{id} ")
    Integer deleteUser(long id);

    @Delete(" delete from user where 1=1 ")
    Integer deleteAllUsers();
}
