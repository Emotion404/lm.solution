package lm.solution.web.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lm.solution.entity.User;
import lm.solution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class MyBatisController {

    private static ObjectMapper objectMapper;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    static {
        objectMapper = new ObjectMapper();
    }

    @RequestMapping(
            value = "/mybatis/userall",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String allUsers() {

        try {
            List<User> users = userService.findAllUsers();
            return objectMapper.writeValueAsString(users);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return "{}";
        }

    }

    @RequestMapping(
            value = "/mybatis/{id}",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getUserById(@PathVariable("id") long id) {

        try {
            User user = userService.findById(id);
            return objectMapper.writeValueAsString(user);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return "{}";
        }
    }

    @RequestMapping(
            value = "/mybatis/create",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String create(@RequestBody User user) {

        try {

            userService.saveUser(user);
            return objectMapper.writeValueAsString(user);

        }catch (JsonProcessingException jpe){
            jpe.printStackTrace();
        }

        return "{}";

    }

    @RequestMapping(
            value = "/mybatis/update",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String update(@RequestBody User user) {

        try {

            userService.updateUser(user);
            return objectMapper.writeValueAsString(user);

        }catch (JsonProcessingException jpe){
            jpe.printStackTrace();
        }

        return "{}";

    }

    @RequestMapping(
            value = "/mybatis/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteById(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "success";

    }

    @RequestMapping(
            value = "/mybatis",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteAll() {
        userService.deleteAllUsers();
        return "success";

    }

}
