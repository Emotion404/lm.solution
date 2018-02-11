package lm.solution.mapper;

import lm.solution.entity.User;
import lm.solution.mapper.provider.UserDynaSqlProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;
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

}
