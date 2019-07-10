package cn.corp.ProvinceService.ProvinceServiceImpl;

import cn.corp.ProvinceService.ProvinceService;
import cn.corp.dao.ProvinceDao;
import cn.corp.dao.daoImpl.ProvinceDaoImpl;
import cn.corp.domain.Province;
import cn.corp.utils.jedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    @Override
    public String findall() {
        Jedis jedis = jedisUtils.getJedis();
        String s = jedis.get("province");
        if (s == null) {
            ProvinceDao provinceDao = new ProvinceDaoImpl();
            List<Province> list = provinceDao.findall();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                s = objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",s);
        }
        jedis.close();

        return s;
    }

    @Override
    public void add(String s) {
        ProvinceDao provinceDao = new ProvinceDaoImpl();
        provinceDao.add(s);
        Jedis jedis = jedisUtils.getJedis();
        jedis.del("province");

    }
}
