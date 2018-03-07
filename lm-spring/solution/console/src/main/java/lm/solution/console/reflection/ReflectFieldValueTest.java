package lm.solution.console.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ReflectFieldValueTest {

    private ArrayList<Object> visited=new ArrayList<>();
    private String toString(Object obj){

        if(obj==null){
            return "null";
        }

        if(visited.contains(obj)){
            return "...";
        }

        visited.add(obj);

        //
        Class cl=obj.getClass();

        if(cl==String.class){
            return (String )obj;
        }

        if(cl.isArray()){
            String r=cl.getComponentType()+"[]{\n";
            for(int i=0;i< Array.getLength(obj);i++){
                if(i>0){
                    r+=",\n";
                }
                Object val=Array.get(obj,i);
                if(cl.getComponentType().isPrimitive()){
                    r+=val;
                }else {
                    r+=toString(val);
                }
            }
            return r+"}";
        }

        //
        String r=cl.getName();
        do{
            r+="[";
            Field[] fields=cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for(Field f : fields){
                if(!Modifier.isStatic(f.getModifiers())){
                    if(!r.endsWith("[")){
                        r+=",\n";
                    }
                    r+=f.getName()+"=";
                    try{
                        Class t=f.getType();
                        // 反射 获取 obj 对象中 字段 f 的值
                        Object val=f.get(obj);
                        if(t.isPrimitive()){
                            r+=val;
                        }else {
                            r+=toString(val);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            r+="]";
            cl=cl.getSuperclass();
        }while (cl!=null);

        //
        return r;

    }

    /**
     * 利用反射获取字段值
     * */
//    @Test
    public void reflectionFieldsValue(){

        ArrayList<Integer> squares=new ArrayList<>();
        for(int i=1;i<=5;i++){
            squares.add(i*i);
        }
        System.out.println(toString(squares));

    }

}

