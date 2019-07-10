package TempleteTest;

import Druidunits.DruidJDBCUnits;
import com.alibaba.druid.util.JdbcUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class test {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidJDBCUnits.getDataSource());

    @Test
    public  void  testadd() {

        String sql="insert into emp values(100826,'詹姆斯邦德',3,1003,null,6666,6666,30)";
        jdbcTemplate.execute(sql);
        //int i = jdbcTemplate.update(sql,"詹姆斯邦德",3,1003,null,6666,6666,30);
        //Assert.assertEquals(1,i);

    }
    @Test
    public void testselect(){
        String sql="select *from emp where id=1001";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        System.out.println(map);
    }
    @Test
    public  void testselect2(){
        String sql="select *from emp ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
    @Test
    public void test05(){
        String sql="select*from emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);

        }

    }
}
