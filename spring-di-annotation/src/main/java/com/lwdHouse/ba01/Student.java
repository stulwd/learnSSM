package com.lwdHouse.ba01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import javax.annotation.Resource;
// component相当与<bean>
// @Component(value = "myStudent")
// @Component("myStudent")  //可以省略value
@Component      // 不指定：创建类名首字母小写的对象
public class Student {
    // @Value注入
    @Value(value = "${myname}")
    private String name;
    private Integer age;


    // @autowired注入
    // // autowired默认是byType注入
    // @Autowired
    // private School school;
    
    // autowired的byName注入如下
    // @Autowired
    // @Qualifier("school")
    // private School school;
    
    // autowired的byName注入, 如果没有找到就不要注入，值为null
    // @Autowired(required = false)
    // @Qualifier("school1")
    // private School school;


    // @Resource自动注入 (必须使用java的较高版本)
    // 先使用byName自动注入，如果注入失败，则使用byType
//    @Resource
    private School school;
    // 如果要求只使用byName，则@Resource(name = "xxx")
    // @Resource(name = "")
    // private School school;


    public Student() {
        System.out.println("==student无参构造方法==");
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Integer return the age
     */
    public Integer getAge() {
        return age;
    }

    // 使用@Value注解不需要set方法
    // /**
    //  * @param name the name to set
    //  */
    // public void setName(String name) {
    //     this.name = name;
    // }

    /**
     * @param age the age to set
     */
    
    @Value(value = "${myage}")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Student{" + 
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school + '\'' +
                '}';
    }
}