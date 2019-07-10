package domain;

import Druidunits.DruidJDBCUnits;
import org.springframework.jdbc.core.JdbcTemplate;

public class studentDAO {
    public static void add(Student student){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(DruidJDBCUnits.getDataSource());
        String sql="insert INTO students VALUES(null,?,?,?,?)";
        jdbcTemplate.update(sql,student.getScroename(),student.getEname(),student.getAge(),student.getGender());
    }
}
