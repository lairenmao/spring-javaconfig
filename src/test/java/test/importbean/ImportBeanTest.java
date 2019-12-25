package test.importbean;

import cn.suming.config.importbean.ImportBeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportBeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ImportBeanConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
