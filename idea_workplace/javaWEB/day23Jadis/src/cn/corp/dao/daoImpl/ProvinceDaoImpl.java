package cn.corp.dao.daoImpl;

import cn.corp.dao.ProvinceDao;
import cn.corp.domain.Province;
import cn.corp.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override

    public List<Province> findall() {

        List<Province> list = jdbcTemplate.query("select * from province", new BeanPropertyRowMapper<>(Province.class));
        return list;
    }

    @Override
    public void add(String s) {
        jdbcTemplate.update("insert into province values(null,?)",s);
    }
}
