package cn.suming.bean.condition;

import cn.suming.bean.simplebean.Person;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class RainBowCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        if (beanFactory.getBeansOfType(Red.class).size()>0&&
                beanFactory.getBeansOfType(Blue.class).size()>0&&beanFactory.getBeansOfType(Green.class).size()>0){
            return true;
        }
        return false;
    }
}
