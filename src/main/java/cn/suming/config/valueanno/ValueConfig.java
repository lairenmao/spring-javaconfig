package cn.suming.config.valueanno;

import cn.suming.bean.valueanno.MyDataSource;
import cn.suming.bean.valueanno.Panda;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySource 将properties文件加载进spring环境,与@Configuration配合使用
 * @Value 取出加载到spring环境中的值
 */
@Configuration
@PropertySource(value = "classpath:db.properties")
public class ValueConfig {
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;
    @Value("${db.driverClassName}")
    private String driverClassName;

    @Bean(name = "myDataSource")
    public MyDataSource myDataSource(){
        MyDataSource dataSource=MyDataSource.builder().username(username).
                password(password).url(url).driverClassName(driverClassName).
                build();
        return dataSource;

    }

    /**
     * #{}是spring EL表达式，${}取值
     * @param color
     * @param weight
     * @return
     */
    @Bean(name = "panda")
    public Panda panda(@Value("${panda.color}") String color,@Value("#{80.5+10}") float weight){
        return new Panda(color,weight);
    }


}
