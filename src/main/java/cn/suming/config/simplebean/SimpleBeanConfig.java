package cn.suming.config.simplebean;

import cn.suming.bean.simplebean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 简单的单个bean创建
 *
 * @Configuration 标注一个java类是配置类，想当于原始的xml
 * @Bean 该方法产生的bean交给spring进行管理
 */
@Configuration
public class SimpleBeanConfig {
    /**
     * bean注解不写name属性，默认创建的bean的加入到spring容器中的对应的beanName是方法名
     * @return
     */
    @Bean(name = "person")
    public Person person(){
        return new Person();
    }

    @Bean(name = "person2")
    public Person person2(){
        return new Person("苏铭",25);
    }

    @Bean(name = "person3")
    public Person person3(){
        Person person=new Person();
        person.setName("苏铭2019");
        person.setAge(25);
        return person;
    }
}
