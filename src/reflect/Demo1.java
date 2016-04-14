package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by annuoaichengzhang on 16/4/14.
 */

class Person {
    private String name;
    private String age;

    public Person() {
    }

    public Person(String name, String age) {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}


public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 正者操作
        Person person = new Person();

        Class<? extends Person> personClass = person.getClass();
        System.out.println(personClass.getName());
        // 输出结果:reflect.Person

        Class<Person> personClass1 = Person.class;
        System.out.println(personClass1.getName());
        // 输出结果:reflect.Person

        Class<?> aClass = Class.forName("reflect.Person");
        Object object = aClass.newInstance();
        Person person1 = (Person) object;

        System.out.println(person1);


        // 构造函数相关
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class);
        Object object3 = constructor.newInstance("张三", "20");
        System.out.println(object3);


        // 全部属性
        Field[] fields = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(object3, "张三");
        System.out.println(name.get(object3));


        // 方法
        Method[] methods = aClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

        Method setName = aClass.getMethod("setName", String.class);
        Method getName = aClass.getMethod("getName");
        setName.invoke(object3, "张四");
        System.out.println(getName.invoke(object3));




    }


}
