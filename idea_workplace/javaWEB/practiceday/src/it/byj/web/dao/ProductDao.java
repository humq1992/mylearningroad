package it.byj.web.dao;

import it.byj.web.domain.Product;
import it.byj.web.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProductDao {

    public List<Product> findAll(){
        DataSource ds = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate=new JdbcTemplate(ds);
        String sql="select * from product";
        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
        return list;
    }
}
