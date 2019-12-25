package test.condition;

import cn.suming.config.condition.ConditionConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ConditionConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);

        }
    }
}
