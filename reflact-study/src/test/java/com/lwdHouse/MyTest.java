package com.lwdHouse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import com.lwdHouse.domain.Person;

import org.junit.Test;


public class MyTest {
    /**
     * 获取类对象的方式
     * @throws ClassNotFoundException
     */
    @Test
    public void test01() throws ClassNotFoundException {
        Person p1 = new Person();
        Class<? extends Person> class1 = p1.getClass();
        Class<?> class2 = Person.class;
        Class<?> class3 = Class.forName("com.lwdHouse.domain.Person");
        System.out.println("p1.getClass: " + class1.toString());
        System.out.println("class1.hashCode():" + class1.hashCode());
        System.out.println("class2.hashCode():" + class2.hashCode());
        System.out.println("class3.hashCode():" + class3.hashCode());
    }

    /**
     * 获取构造器，并使用构造器new对象
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    @Test
    public void test02() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> class1 = Class.forName("com.lwdHouse.domain.Person");
        Constructor<?>[] cons = class1.getConstructors();
        for (Constructor<?> con : cons) {
            System.out.println("constructor:" + con);
        }

        Constructor<?> con = class1.getConstructor(String.class, Integer.class);
        Person p2 = (Person) con.newInstance("lwd", 24);
        System.out.println("p2:"+p2);

        Constructor<?> con1 = class1.getConstructor();
        Person p3 = (Person) con1.newInstance();
        System.out.print("p3:"+p3);
    }

    /**
     * 获取方法
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    @Test
    public void test03() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> class1 = Class.forName("com.lwdHouse.domain.Person");
        Method[] meds = class1.getMethods();
        for (Method med : meds) {
            System.out.println("method: "+med);
        }
        Method[] decMeds = class1.getDeclaredMethods();
        for (Method dm : decMeds) {
            System.out.println("DeclaredMethods:"+dm);
        }

        Method method1 = class1.getMethod("staticMethod");
        method1.invoke(null);

        Person p1 = new Person("zhangsan", 18);
        Method method2 = class1.getMethod("toString");
        System.out.println(method2.invoke(p1));

        Method method3 = p1.getClass().getDeclaredMethod("privateMethod", String.class);
        method3.setAccessible(true);
        method3.invoke(p1, "abc");
    }

    /**
     * 编写一个能调用任何方法的方法
     * @param obj
     * @param method
     * @param type
     * @param args
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void invokeAny(Object obj, String method, Class<?>[] type, Object... args) throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // Class<?>[] claList;
        // ArrayList<Class<?>> al = new ArrayList<Class<?>>();
        // for (Object arg : args) {
        //     al.add(arg.getClass());
        // }
        // System.out.println(al);
        // Class<?> c1 = al.get(0);
        // Class<?> c2 = al.get(1);
        
        Class<? extends Object> class1 = obj.getClass();
        Method method1 = class1.getMethod(method, type);
        method1.invoke(obj, args);
    }

    /**
     * 使用invokeAny
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    @Test
    public void test04() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Person p1 = new Person("lwd", 22);
        invokeAny(p1, "fun2", new Class[] {String.class, Integer.class}, "abc", 123);
        invokeAny(p1, "fun1", new Class[] {Integer.class}, 123);

        Properties prop = new Properties();
        // prop.setProperty(key, value)
        invokeAny(prop, "setProperty", new Class[] {String.class, String.class}, "username", "张三");
        System.out.println(prop.toString());
    }

    @Test
    public void test05() throws ClassNotFoundException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        Class<?> class1 = Class.forName("com.lwdHouse.domain.Person");
        Field[] fis = class1.getDeclaredFields();
        for (Field f : fis) {
            System.out.println("field:"+f);
        }
        Person p = new Person("lwd", 0);
        Field f = class1.getDeclaredField("age");
        f.setAccessible(true);
        f.set(p, 24);
        System.out.println("person:"+p);
        System.out.println("p.age="+(f.get(p)));
        
    }
}