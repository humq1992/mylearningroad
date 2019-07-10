package cn.corp.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class jedisUtils {
    private static JedisPool jedisPool;
    static {
        InputStream is = jedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pp = new Properties();
        try {
            pp.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pp.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pp.getProperty("maxIdle")));
        jedisPool=new JedisPool(config,pp.getProperty("host"),Integer.parseInt(pp.getProperty("port")));

    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
