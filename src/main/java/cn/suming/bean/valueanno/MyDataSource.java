package cn.suming.bean.valueanno;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MyDataSource {
    private String username;
    private String password;
    private String url;
    private String driverClassName;
}
