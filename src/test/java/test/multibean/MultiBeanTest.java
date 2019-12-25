package test.multibean;

import cn.suming.bean.multibean.Course;
import cn.suming.config.multibean.MultiBeanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MultiBeanTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(MultiBeanConfig.class);
        Object student = context.getBean("student");
        Course course = context.getBean(Course.class);
        System.out.println(student);
        System.out.println(course);
    }
}
