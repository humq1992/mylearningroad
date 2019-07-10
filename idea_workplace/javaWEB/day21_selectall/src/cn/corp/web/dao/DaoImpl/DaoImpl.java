package cn.corp.web.dao.DaoImpl;

import cn.corp.web.dao.Dao;
import cn.corp.web.domain.Member;
import cn.corp.web.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DaoImpl implements Dao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Member> findall() {
        String sql="select *from member";
        List<Member> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));
        return list;
    }
}
