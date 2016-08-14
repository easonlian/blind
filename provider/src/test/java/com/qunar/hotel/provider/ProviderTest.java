package com.qunar.hotel.provider;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by easonlian on 16-7-12.
 */
public class ProviderTest {

    private ClassPathXmlApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        ctx.start();
    }

    @Test
    public void test1() throws Exception {
        System.in.read();
    }
}
