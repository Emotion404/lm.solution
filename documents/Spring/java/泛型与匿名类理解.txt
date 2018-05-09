

//
文章：
https://www.cnblogs.com/yjmyzz/p/3448330.html
https://www.cnblogs.com/EasonJim/p/7967096.html



// Java中泛型T和Class<T>以及Class<?>的理解
1.Class类的实例表示Java应用运行时的类（class and enum）或接口（interface and annotation）
2.每个Java类运行时都在JVM里表现为一个Class对象，可通过类名.class，类型.getClass()，Class.forName("类名")等方法获取Class对象）。
3.数组同样也被映射为为Class对象的一个类，所有具有相同元素类型和维数的数组都共享该Class对象。
4.基本类型boolean，byte，char，short，int，long，float，double和关键字void同样表现为Class对象。
-------
T  bean
Class<T> bean
Class<?> bean
单独的T代表一个类型，而Class<T>和Class<?>代表这个类型所对应的类型类
-------
Class<T>在实例化的时候，T要替换成具体类
Class<?>它是个通配泛型，?可以代表任何类型
<? extends T>上限通配，表示T的一个未知子类。
<? super T>下限通配，表示T的一个未知父类。
public T find(Class<T> clazz, int id);
根据类来反射生成一个实例，而单独用T没法做到。
-------
Object类中包含一个方法名叫getClass，利用这个方法就可以获得一个实例的类型类。
类型类指的是代表一个类型的类，因为一切皆是对象，类型也不例外，在Java使用类型类来表示一个类型。
所有的类型类都是Class类的实例。
getClass()会看到返回Class<?>。
JDK中，普通的Class.newInstance()方法的定义返回Object，要将该返回类型强制转换为另一种类型;
但是使用泛型的Class<T>，Class.newInstance()方法具有一个特定的返回类型;



// 匿名类
如：
 public interface ISay {
     void sayHello();
 }
 ---->
 ISay say = new ISay() {
     public void sayHello() {
         System.out.println("Hello java!");
     }
 };
说明：
如果有些场合，只需要临时需要创建一个接口的实现类，上面的"技巧"可以用来简化代码.
其它类似，如子类，等等
