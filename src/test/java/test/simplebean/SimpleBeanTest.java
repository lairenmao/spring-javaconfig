package test.simplebean;

import cn.suming.bean.simplebean.Person;
import cn.suming.config.simplebean.SimpleBeanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleBeanTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(SimpleBeanConfig.class);
        Object person = context.getBean("person");
        Object person2 = context.getBean("person2");
        Object person3 = context.getBean("person3");
        System.out.println("person:"+person);
        System.out.println("person2:"+person2);
        System.out.println("person3:"+person3);


    }

}
