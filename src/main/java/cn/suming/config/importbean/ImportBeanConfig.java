package cn.suming.config.importbean;

import cn.suming.bean.importbean.MyImportBeanDefinitionRegistry;
import cn.suming.bean.importbean.MyImportSelector;
import cn.suming.bean.importbean.Rabbit;
import cn.suming.bean.importbean.Tiger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Import 导入别的@Configuration标注的配置类、普通的类、
 * 或者导入ImportSelector或者ImportBeanDefinitionRegistrar的实现类实现自定义导入功能
 */
@Configuration
@Import(value = {OtherConfig.class,Tiger.class,MyImportSelector.class, MyImportBeanDefinitionRegistry.class})
public class ImportBeanConfig {
    @Bean
    public Rabbit rabbit(){
        return new Rabbit();
    }
}
