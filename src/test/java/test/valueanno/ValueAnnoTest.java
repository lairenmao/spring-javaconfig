package test.valueanno;

import cn.suming.bean.valueanno.MyDataSource;
import cn.suming.bean.valueanno.Panda;
import cn.suming.config.valueanno.ValueConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValueAnnoTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ValueConfig.class);
        MyDataSource myDataSource = context.getBean(MyDataSource.class);
        Panda panda = context.getBean(Panda.class);
        System.out.println(myDataSource);
        System.out.println(panda);
        String property = context.getEnvironment().getProperty("os.name");
        System.out.println(property);
    }
}
