package conifg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan("com.itheima")
@Import(jdbcconfig.class)
//确认扫描的配置的包 标注后此类与XML中的<context:component-scan base-package="org.example"/>相同功能
public class applicationconfig {

}
