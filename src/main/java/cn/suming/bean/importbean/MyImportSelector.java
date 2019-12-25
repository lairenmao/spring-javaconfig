package cn.suming.bean.importbean;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ImportSelector一般会和Aware相关的接口配合使用，Aware接口的methods会优先于ImportSelector的方法执行
 * 可以和ImportSelector结合使用的Aware接口有：
 * BeanClassLoaderAware/BeanFactoryAware/EnvironmentAware/ResourceLoaderAware
 * 源码中解析ImportSelector的时候会先去判断该ImportSelector是否有实现Aware接口，有的话先解析Aware
 * {@link org.springframework.context.annotation.ConfigurationClassParser}配置类解析类
 * ImportSelector selector = BeanUtils.instantiateClass(candidateClass, ImportSelector.class);
 * ParserStrategyUtils.invokeAwareMethods(selector, this.environment, this.resourceLoader, this.registry);
 */
public class MyImportSelector implements ImportSelector, EnvironmentAware, ResourceLoaderAware {
    private Environment environment;
    private ResourceLoader resourceLoader;
    private static final String PATH = "MET-INF/services/spring.factories";

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> beanNames = new ArrayList<>();
        /**
         * 这里如果需要解耦合的话可以使用spi机制进行类名的注入
         */
        if (environment.getProperty("os.name").contains("Mac")) {
            // beanNames.add("cn.suming.bean.importbean.Mac");
            String className = parseFactories();
            beanNames.add(className);
        }
        return beanNames.toArray(new String[]{});

    }

    private String parseFactories() {
        String className = null;
        InputStream inputStream = resourceLoader.getClassLoader().getResourceAsStream(PATH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                // 读取文件中的每一行
                // spi 文件需要严格按照 alias=className 格式编写
                String[] aliasAndClassName = line.split("=");
                // 任何不是 alias=className 格式的行都直接过滤掉
                if (aliasAndClassName == null || aliasAndClassName.length != 2) {
                    break;
                }
                className = aliasAndClassName[1].trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
    }
}
