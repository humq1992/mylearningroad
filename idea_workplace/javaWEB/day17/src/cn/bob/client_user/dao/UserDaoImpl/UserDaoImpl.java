package cn.bob.client_user.dao.UserDaoImpl;

import cn.bob.client_user.dao.UserDao;
import cn.bob.client_user.domain.User;
import cn.bob.client_user.untils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findall() {
        String sql="select * from user";


        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));


        return list;
    }

    @Override
    public User login(User user) {

        String sql="select*from user where username=? and password=?";
        User u = null;
        try {
            u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public User find(int id) {
        String sql="select * from user where id=?";
        User u=null;
        try {
            u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public void submitupdate(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,emil=? where id=?";
        int i = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmil(), user.getId());
    }

    @Override
    public void add(User user) {
        String sql="insert into user values (null,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmil(),user.getUsername(),user.getPassword());
    }

    @Override
    public void delete(int uid) {
        String sql="delete from user where id=?";
        jdbcTemplate.update(sql,uid);
    }

    @Override
    public void deleteselected(String[] ids) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < ids.length; i++) {
            sb.append(ids[i]+",");
        }
        StringBuilder s = sb.replace(sb.lastIndexOf(","), sb.length(), ")");
        String sql="delete from user where id in"+s;
        jdbcTemplate.update(sql);
    }

    @Override
    public int getcount(User u) {
        ArrayList<Object> parameter = new ArrayList<>();
        String sql="select count(*) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        if(u.getName()!=null && !u.getName().equals("")){
            sb.append(" and name like ?");
            parameter.add("%"+u.getName()+"%");
        }
        if(u.getAddress()!=null && !u.getAddress().equals("")){
            sb.append(" and address like ?");
            parameter.add("%"+u.getAddress()+"%");
        }
        if(u.getEmil()!=null && !u.getEmil().equals("")){
            sb.append(" and emil like ?");
            parameter.add("%"+u.getEmil()+"%");
        }
        sql=sb.toString();
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class,parameter.toArray());
        return count;
    }

    @Override
    public List<User> findbypage(int start, int rows,User u) {
        ArrayList<Object> parameter = new ArrayList<>();
        String sql="select * from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        if(u.getName()!=null && !u.getName().equals("")){
            sb.append(" and name like ?");
            parameter.add("%"+u.getName()+"%");
        }
        if(u.getAddress()!=null && !u.getAddress().equals("")){
            sb.append(" and address like ?");
            parameter.add("%"+u.getAddress()+"%");
        }
        if(u.getEmil()!=null && !u.getEmil().equals("")){
            sb.append(" and emil like ?");
            parameter.add("%"+u.getEmil()+"%");
        }
        sb.append(" limit ?,?");
        parameter.add(start);
        parameter.add(rows);
        sql=sb.toString();
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), parameter.toArray());
        return list;
    }
}
