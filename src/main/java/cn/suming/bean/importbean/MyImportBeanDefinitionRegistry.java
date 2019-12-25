package cn.suming.bean.importbean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 向beanFactory中注册bean的定义信息
 * ImportBeanDefinitionRegistrar一般与Aware接口结合使用，Aware接口的方法优先于
 * ImportBeanDefinitionRegistrar的方法执行
 * 可以和ImportBeanDefinitionRegistrar结合使用的Aware接口有：
 * BeanClassLoaderAware/BeanFactoryAware/EnvironmentAware/ResourceLoaderAware
 */
public class MyImportBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    public Environment environment;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (environment.getProperty("os.name").contains("Mac")){
            registry.registerBeanDefinition("macPro",new RootBeanDefinition(Mac.class));
        }
    }
}
