package conifg;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;
@Configuration
public class jdbcconfig {
    @Bean(name = "datasource")
    public DataSource creatdatasource(){
         DataSource ds=null;
        try {
            Properties pp = new Properties();
            pp.load(jdbcconfig.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
  return ds;

    }
    @Bean(name = "jdbctemplate")
    @Scope("prototype")
    public JdbcTemplate getjdbcTemplate(DataSource datasource){
        JdbcTemplate jdbctemplate = new JdbcTemplate(datasource);
        return jdbctemplate;


    }
}
