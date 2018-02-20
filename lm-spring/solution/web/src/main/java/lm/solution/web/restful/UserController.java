package lm.solution.web.restful;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lm.solution.entity.User;
import lm.solution.web.config.beans.HttpClientUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private static ObjectMapper objectMapper;
    private static JsonGenerator jsonGenerator;

    static {
        try {
            objectMapper = new ObjectMapper();
            jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @RequestMapping(
            value = "/user/userall",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String allUsers() {

        try {
            String result = HttpClientUtils.doGet("http://localhost:8081/api/user");

            // json --> model
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, User.class);
            List<User> users = objectMapper.readValue(result, javaType);

            // model --> json
            String json = objectMapper.writeValueAsString(users);
            return json;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return "{}";
        }

    }

    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getUserById(@PathVariable("id") long id) {

        try {
            String result = HttpClientUtils.doGet("http://localhost:8081/api/user/" + id);

            // json --> model
            User user = objectMapper.readValue(result, User.class);

            // model --> json
            String json = objectMapper.writeValueAsString(user);

            return json;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return "{}";
        }
    }

    @RequestMapping(
            value = "/user/create",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String create(@RequestBody User user) {

        HttpClientUtils.doPost("http://localhost:8081/api/user/", user);

        return "{}";

    }

    @RequestMapping(
            value = "/user/update",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String update(@RequestBody User user){

        HttpClientUtils.doPut("http://localhost:8081/api/user/"+user.getId(),user);

        return "{}";

    }

    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteById(@PathVariable("id") long id){

        HttpClientUtils.doDelete("http://localhost:8081/api/user/"+id);

        return "{}";

    }

    @RequestMapping(
            value = "/user",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteAll(){

        HttpClientUtils.doDelete("http://localhost:8081/api/user/");

        return "{}";

    }

}
