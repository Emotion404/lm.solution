package lm.solution.console.json.fastjson;

import com.alibaba.fastjson.JSONReader;
import lm.solution.pojo.model.console.BeginEndBean;
import lm.solution.pojo.model.console.JsonComplex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * JSONArray 相当于 JAVA中的List<Object>，如：['a','b','c'....]
 * JSONObject相当于JAVA中的Map<String, Object>，如：{'1':'a', '2':'b'...}
 * 对于具有结构层次的JSON格式的数据，可以一层一层地来解析
 * 当待解析的JSON文件很大时，可使用JSON Stream API
 */
public class FastjsonTest {

    private static final String FILE_PATH = "F:\\Java\\lm.solution\\lm-spring\\solution\\Docs\\Json\\jsontest.txt";

    public void parseListByFastjsonStreamApi() {

        try {

            JSONReader reader = new JSONReader(new FileReader(new File(FILE_PATH)));

            // [
            reader.startArray();
            while (reader.hasNext()) {
                // {"key":"value"}
                String info = reader.readObject().toString();
                System.out.println(info);
            }
            // ]
            reader.endArray();

            reader.close();

            // --------------------------------------------------------------------------

            JSONReader reader1 = new JSONReader(new FileReader(new File(FILE_PATH)));

            reader1.startArray();
            while (reader1.hasNext()) {
                reader1.startObject();
                while (reader1.hasNext()) {
                    String key = reader1.readString();
                    String val = reader1.readObject().toString();
                    System.out.println("key: " + key + ", value: " + val);
                }
                reader1.endObject();
            }
            reader1.endArray();

            reader1.close();

            // --------------------------------------------------------------

            JSONReader reader2 = new JSONReader(new FileReader(new File(FILE_PATH)));

            reader2.startArray();
            while (reader2.hasNext()) {
                // 根据 java bean 来解析
                BeginEndBean obj = reader2.readObject(BeginEndBean.class);
                int begin = obj.getBegin_int();
                int end = obj.getEnd_int();
                System.out.println("begin_int:" + begin + ", end_int" + end);
            }
            reader2.endArray();

            reader2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static final String FILE_PATH2 = "F:\\Java\\lm.solution\\lm-spring\\solution\\Docs\\Json\\jsontest2.txt";

    public void parseComplexObject() {

        try {

            JSONReader reader = new JSONReader(new FileReader(new File(FILE_PATH2)));

            // 将整个json文件当作 Map<String,Object> 对象来解析 {,}
            reader.startObject();
            while (reader.hasNext()) {
                String key = reader.readString();
                // "key"对应的Object只有一个
                if (key.equals("key")) {
                    Object obj = reader.readObject();
                    String val = obj.toString();
                    System.out.println("obj: " + obj + ", value: " + val);
                }
                // "anotherKey"对应的是一个List对象
                else if (key.equals("anotherKey")) {
                    reader.startArray();
                    while (reader.hasNext()) {
                        reader.startObject();
                        while (reader.hasNext()) {
                            String objKey = reader.readString();
                            String objVal = reader.readObject().toString();
                            System.out.println("objKey: " + objKey + ", objVal: " + objVal);
                        }
                        reader.endObject();
                    }
                    reader.endArray();
                }
                // {"subKey":"subVal","anotherSubKey":["1","2","3"]}
                else if (key.equals("thirdKey")) {
                    reader.startObject();
                    while (reader.hasNext()) {
                        String sub_key = reader.readString();
                        Object third_obj = reader.readObject();
                        String subVal = third_obj.toString();
                        System.out.println("sub_key: " + sub_key + ", subVal: " + subVal);
                    }
                    reader.endObject();
                }
            }
            reader.endObject();

            reader.close();

            // ----------------------------------------------------------------------------

            JSONReader reader1 = new JSONReader(new FileReader(new File(FILE_PATH2)));
            JsonComplex complex = reader1.readObject(JsonComplex.class);
            //String json= JsonGenerator
            System.out.println(complex.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
