package cn.suming.config.multibean;

import cn.suming.bean.multibean.Course;
import cn.suming.bean.multibean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建一个bean时属性是另外一个bean的情况
 *
 * 这里course、student方法先后顺序没有影响，因为spring解析@Configuration
 * 配置类加载beanDefinition定义信息跟beanDefinition定义信息解析创建bean实例是两个分开的步骤
 */
@Configuration
public class MultiBeanConfig {
    @Bean(name = "course")
    public Course course(){
        return new Course();
    }

    /**
     * @param course 已经交给spring管理的对应的bean
     * @return
     */
    @Bean(name = "student")
    public Student student(@Autowired Course course){
        return new Student(course);
    }

    @Bean(name = "student2")
    public Student student2(){
        return new Student(course());
    }

}
