package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FindUserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FindUserDaoImpl  implements FindUserDao{
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUser(User user) {

        User u = null;
        try {
            u = jdbcTemplate.queryForObject("select*from tab_user where username=?", new BeanPropertyRowMapper<>(User.class), user.getUsername());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public void addUser(User user) {
        String sql="insert into tab_user values(null,?,?,?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getBirthday(),user.getSex(),user.getTelephone(),user.getEmail(),user.getStatus(),user.getCode());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void activeuser(String uuid) {
        jdbcTemplate.update("UPDATE tab_user set status='Y' where code=?",uuid);
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("select * from tab_user where username=? and password=?", new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findbyusername(String username) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("select * from tab_user where username=?", new BeanPropertyRowMapper<>(User.class), username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}
