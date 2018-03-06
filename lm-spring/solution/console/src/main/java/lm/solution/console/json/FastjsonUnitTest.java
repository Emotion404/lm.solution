package lm.solution.console.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lm.solution.pojo.model.console.fastjsonunittest.Student;
import lm.solution.pojo.model.console.fastjsonunittest.Teacher;

import java.util.ArrayList;
import java.util.List;

public class FastjsonUnitTest {

    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    /**
     * json字符串-简单对象型到JSONObject的转换
     * */
//    @Test
    public void testJSONStrToJSONObject(){

        JSONObject jsonObject=JSONObject.parseObject(JSON_OBJ_STR);
        System.out.println(
                "studentName:  " + jsonObject.getString("studentName") + ":"
                        + "  studentAge:  " + jsonObject.getInteger("studentAge"));

    }

    /**
     * JSONObject到json字符串-简单对象型的转换
     */
//    @Test
    public void testJSONObjectToJSONStr(){

        // 已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject=JSONObject.parseObject(JSON_OBJ_STR);
        String json=jsonObject.toJSONString(jsonObject);
        System.out.println(json);

    }

    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    /**
     * json字符串-数组类型到JSONArray的转换
     */
//    @Test
    public void testJSONStrToJSONArray(){

        JSONArray jsonArray=JSONArray.parseArray(JSON_ARRAY_STR);

        // 遍历方式1
        int size=jsonArray.size();
        for(int i=0;i<size;i++){

            JSONObject jsonObject=jsonArray.getJSONObject(i);
            System.out.println("studentName:  " +jsonObject.getString("studentName") + ":"
                    + "  studentAge:  "+jsonObject.getInteger("studentAge"));

        }

        // 遍历方式2
        for (Object obj : jsonArray){

            JSONObject jsonObject=(JSONObject)obj;
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));

        }

    }

    /**
     * JSONArray到json字符串-数组类型的转换
     */
//    @Test
    public void testJSONArrayToJSONStr(){

        // 已知JSONArray,目标要转换为json字符串
        JSONArray jsonArray=JSONArray.parseArray(JSON_ARRAY_STR);
        String json=JSONArray.toJSONString(jsonArray);
        System.out.println(json);

    }

    private static final String JSON_COMPLEX_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"Course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    /**
     * 复杂json格式字符串到JSONObject的转换
     */
//    @Test
    public void testComplexJSONStrToJSONObject(){

        JSONObject jsonObject=JSONObject.parseObject(JSON_COMPLEX_STR);

        String teacherName=jsonObject.getString("teacherName");
        Integer teacherAge=jsonObject.getInteger("teacherAge");

        System.out.println("teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);

        JSONObject jsonObjectcourse =jsonObject.getJSONObject("Course");

        // 获取JSONObject中的数据
        String courseName=jsonObjectcourse.getString("courseName");
        Integer code=jsonObjectcourse.getInteger("code");

        System.out.println("courseName:  " + courseName + "   code:  " + code);

        JSONArray jsonArraystudents=jsonObject.getJSONArray("students");

        // 遍历JSONArray
        for(Object object : jsonArraystudents){

            JSONObject jsonObjectone =(JSONObject)object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");

            System.out.println("studentName:  " + studentName + "   studentAge:  " + studentAge);

        }

    }

    /**
     * 复杂JSONObject到json格式字符串的转换
     */
//    @Test
    public void testJSONObjectToComplexJSONStr(){

        // 复杂JSONObject,目标要转换为json字符串
        JSONObject jsonObject=JSONObject.parseObject(JSON_COMPLEX_STR);
        String json=jsonObject.toJSONString(jsonObject);
        System.out.println(json);

    }

    /**
     * json字符串-简单对象到JavaBean之间的转换
     */
//    @Test
    public void testJSONStrToJavaBeanObj(){

        // 第一种方式
        JSONObject jsonObject=JSONObject.parseObject(JSON_OBJ_STR);
        String studentName = jsonObject.getString("studentName");
        Integer studentAge = jsonObject.getInteger("studentAge");
        Student student=new Student(studentName,studentAge);
        System.out.println(jsonObject.toJSONString(student));

        // 第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        Student student1=JSONObject.parseObject(JSON_OBJ_STR,new TypeReference<Student>(){});
        System.out.println(jsonObject.toJSONString(student1));

        // 第三种方式,使用Gson的思想
        Student student2=JSONObject.parseObject(JSON_OBJ_STR,Student.class);
        System.out.println(jsonObject.toJSONString(student2));

    }

    /**
     * JavaBean到json字符串-简单对象的转换
     */
//    @Test
    public void testJavaBeanObjToJSONStr(){

        Student student=new Student("lily",12);
        String json=JSONObject.toJSONString(student);
        System.out.println(json);

    }

    /**
     * json字符串-数组类型到JavaBean_List的转换
     */
//    @Test
    public void  testJSONStrToJavaBeanList(){

        // 第一种方式
        JSONArray jsonArray=JSONArray.parseArray(JSON_ARRAY_STR);

        // 遍历JSONArray
        List<Student> studentList=new ArrayList<>();
        for (Object object :jsonArray){

            Student student=null;

            JSONObject jsonObjectone=(JSONObject)object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");

            student = new Student(studentName,studentAge);
            studentList.add(student);

        }
        System.out.println(JSONObject.toJSONString(studentList));

        // 第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        List<Student> studentList1=JSONArray.parseObject(JSON_ARRAY_STR,new TypeReference<List<Student>>(){});

        System.out.println(JSONObject.toJSON(studentList1));

        // 第三种方式,使用Gson的思想
        List<Student> studentList2=JSONArray.parseArray(JSON_ARRAY_STR,Student.class);
        System.out.println(JSONArray.toJSONString(studentList2));

    }

    /**
     * JavaBean_List到json字符串-数组类型的转换
     */
//    @Test
    public void testJavaBeanListToJSONStr(){

        Student student = new Student("lily", 12);
        Student studenttwo = new Student("lucy", 15);

        List<Student> students=new ArrayList<>();
        students.add(student);
        students.add(studenttwo);

        String json=JSONArray.toJSONString(students);
        System.out.println(json);

    }

    /**
     * 复杂json格式字符串到JavaBean_obj的转换
     */
//    @Test
    public void  testComplexJSONStrToJavaBean(){

        // 第一种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        Teacher teacher=JSONObject.parseObject(JSON_COMPLEX_STR,new TypeReference<Teacher>(){});
        System.out.println(JSONObject.toJSONString(teacher));

        // 第二种方式,使用Gson思想
        Teacher teacher1=JSONObject.parseObject(JSON_COMPLEX_STR,Teacher.class);
        System.out.println(JSONObject.toJSONString(teacher1));

    }

    /**
     * 复杂JavaBean_obj到json格式字符串的转换
     */
//    @Test
    public void testJavaBeanToComplexJSONStr(){

        // 已知复杂JavaBean_obj
        Teacher teacher=JSONObject.parseObject(JSON_COMPLEX_STR,Teacher.class);
        String json=JSONObject.toJSONString(teacher);
        System.out.println(json);

    }

    // 2.3.1

}
