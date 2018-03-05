package lm.solution.service.mysql;

import lm.solution.pojo.entity.User;
import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findById(long id);

    boolean isUserExist(User user);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    void deleteAllUsers();

}
