package lm.solution.console.json.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import lm.solution.pojo.model.console.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Jackson1xTest {

    public void json2Collection(){

        try {

            // 后面几种转换同 Jackson2xTest 一样  //对象转JSON  //map转JSON  //list转JSON  //JSON转java对象

            // JSON转list
            ObjectMapper objectMapper = new ObjectMapper();
            String listJson = "[{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"},"
                    + "{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"},"
                    + "{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}]";
            List<User> userList = objectMapper.readValue(listJson, new TypeReference<List<User>>() {
            });
            for (User user1:userList){
                System.out.println(user1.getName()+"\t"+user1.getAge()+"\t"+user1.getAddress());
            }

            // JSON转map
            String mapJson="{\"one\":{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"},"
                    + "\"two\":{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"},"
                    + "\"three\":{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}}";
            Map<String,User> userMap=objectMapper.readValue(mapJson,new TypeReference<Map<String,User>>(){});
            User one=userMap.get("one");
            User two=userMap.get("two");
            User three=userMap.get("three");
            System.out.println(one.getName()+"\t"+one.getAge()+"\t"+one.getAddress());
            System.out.println(two.getName()+"\t"+two.getAge()+"\t"+two.getAddress());
            System.out.println(three.getName()+"\t"+three.getAge()+"\t"+three.getAddress());

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
