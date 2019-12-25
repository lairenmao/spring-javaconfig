package cn.suming.config.condition;

import cn.suming.bean.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {
    @Bean(name = "red")
    public Red red(){
       return new Red();
    }
    @Bean(name = "green")
    public Green green(){
        return new Green();
    }
    @Bean(name = "blue")
    public Blue blue(){
        return new Blue();
    }
    @Bean(name = "rainBow")
    @Conditional(value = {RainBowCondition.class})
    public RainBow rainBow(){
        return new RainBow();
    }

}
