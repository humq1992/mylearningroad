package cn.itheima.dao;

import cn.itheima.domain.User;
import cn.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class Userdao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public User getUser(User user) {
        User u=null;

        try {
            u = jdbcTemplate.queryForObject("select*from user where name=? && password=?", new BeanPropertyRowMapper<User>(User.class), user.getName(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return u;

    }

}
