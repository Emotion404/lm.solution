package lm.solution.console.json.jackson;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lm.solution.pojo.model.console.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jackson2xTest {

    public void object2Json() {

        try {
            //
            ObjectMapper objectMapper = new ObjectMapper();
//            JsonGenerator jsonGenerator = objectMapper
//                    .getJsonFactory()
//                    .createJsonGenerator(System.out, JsonEncoding.UTF8);

            // 对象转JSON
            User user = new User("张三", 23, "深圳市");
            System.out.println("ObjectMapper方式 -- 对象转JSON");
//            objectMapper.writeValue(System.out, user);  // 直接输出到控制台
            String userJsonStr = objectMapper.writeValueAsString(user);  // 返回字符串，输出
            System.out.println(userJsonStr);
            System.out.println("JsonGenerator方式 -- 对象转JSON");
//            jsonGenerator.writeObject(user);
            System.out.println();

            // map转JSON
            Map<String, Object> map = new HashMap<>();
            map.put("one", new User("张", 12, "深圳"));
            map.put("two", new User("李", 22, "武汉"));
            map.put("three", new User("王", 32, "北京"));
            System.out.println("ObjectMapper方式 -- map转JSON");
//            objectMapper.writeValue(System.out, map);
            String strMap = objectMapper.writeValueAsString(map);
            System.out.println(strMap);

            // list转JSON
            List<User> list = new ArrayList<>();
            list.add(new User("张", 12, "深圳"));
            list.add(new User("李", 22, "武汉"));
            list.add(new User("王", 32, "北京"));
            System.out.println("ObjectMapper方式 -- list转JSON");
//            objectMapper.writeValue(System.out, list);
            String strList = objectMapper.writeValueAsString(list);
            System.out.println(strList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void json2Object(){

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            // JSON转java对象
            String json = "{\"name\":\"张三\",\"age\":23,\"address\":\"深圳市\"}";
            User zhang = objectMapper.readValue(json, User.class);
            System.out.println(zhang.getName()+"\n"+zhang.getAge()+"\n"+zhang.getAddress());

            // JSON转list
            String listJson="[{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"},"
                    + "{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"},"
                    + "{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}]";
            JavaType javaType1=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,User.class);
            List<User> userList=(List<User>) objectMapper.readValue(listJson,javaType1);
            for(User user1 : userList){
                System.out.println(user1.getName()+"\t"+user1.getAge()+"\t"+user1.getAddress());
            }

            // JSON转map
            String mapJson="{\"one\":{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"},"
                    + "\"two\":{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"},"
                    + "\"three\":{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}}";
            JavaType javaType2=objectMapper.getTypeFactory().constructParametricType(HashMap.class,String.class,User.class);
            Map<String ,User> userMap=(Map<String, User>) objectMapper.readValue(mapJson,javaType2);
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


