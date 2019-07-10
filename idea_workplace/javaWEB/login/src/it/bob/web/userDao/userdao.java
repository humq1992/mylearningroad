package it.bob.web.userDao;


import it.bob.web.Utils.JDBCUtils;
import it.bob.web.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class userdao {
    public User finduser(User user){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select*from user where username=? && password=?";
        User tempuser= null;
        try {
            tempuser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempuser;
    }
}
