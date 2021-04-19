package designMode;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.lwdHouse.designMode.annotation.Person;
import com.lwdHouse.designMode.annotation.PersonInfo;
import com.lwdHouse.designMode.myEnum.Gender;
import com.lwdHouse.designMode.singleton.SingletonLanHan;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * 单例模式测试
     */
    @Test
    public void test01() {
        SingletonLanHan.getInstance();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println(SingletonLanHan.getInstance().hashCode());
            }
        };
        int num = 30;
        Thread[] threadList = new Thread[num];
        for (int i = 0; i < num; i++) {
            threadList[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(SingletonLanHan.getInstance3().hashCode());
                }
            });
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }

    /**
     * 枚举模式
     */
    @Test
    public void test02() {
        Gender gender = Gender.MALE;
        System.out.println("Gender:" + gender.toString());
    }

    /**
     * 用反射获取注解
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
        Class<?> cla = Class.forName("com.lwdHouse.designMode.annotation.Person");
        Method med = cla.getMethod("show2", String.class, int.class, String.class);
        PersonInfo pinfo = med.getAnnotation(PersonInfo.class);
        // 这里再运行时如果报空指针，说明注解的元注解@Retention设置的不对
        System.out.println(pinfo.name());
        System.out.println(pinfo.age());
        System.out.println(pinfo.sex());
        Person yue = new Person();
        med.invoke(yue, pinfo.name(), pinfo.age(), pinfo.sex());
    }
}
