package cn.suming.config.importbean;

import cn.suming.bean.importbean.Snake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {
    @Bean(name = "snake")
    public Snake snake(){
        return new Snake();
    }
}
