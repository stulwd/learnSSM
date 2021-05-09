package com.lwdHouse;

import static org.junit.Assert.assertTrue;

import com.lwdHouse.service.BuyGoods;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoods service = (BuyGoods) ctx.getBean("buyGoodsImpl");
        System.out.println("service对象: "+service.getClass().getName());
        // service对象: com.sun.proxy.$Proxy20 说明Transaction将service转换成了一个动态代理对象
        service.buy(1001, 2);
    }
}
