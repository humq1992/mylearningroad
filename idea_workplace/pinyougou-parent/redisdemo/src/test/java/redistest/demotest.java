package redistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class demotest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() {
        redisTemplate.boundValueOps("name").set("yyy");

    }

    @Test
    public void getValue() {
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);

    }

    @Test
    public void deleValue() {
        redisTemplate.delete("name");


    }

    @Test
    public void setSet() {
        redisTemplate.boundSetOps("hero").add("zhaosi");
        redisTemplate.boundSetOps("hero").add("wangwu");
        redisTemplate.boundSetOps("hero").add("liuneng");
    }

    @Test
    public void getSet() {
        //set具有无序的特征
        Set name = redisTemplate.boundSetOps("hero").members();
        System.out.println(name);
    }
    @Test
    public void setlist(){
        //右压栈可以依次向数组后加入  左压栈相反
        redisTemplate.boundListOps("list").rightPush("nihao");
        redisTemplate.boundListOps("list").rightPush("wo");
        redisTemplate.boundListOps("list").rightPush("jiao");
        redisTemplate.boundListOps("list").rightPush("zz");
    }
    @Test
    public void getList() {
        //set具有无序的特征
        List list = redisTemplate.boundListOps("list").range(0, 10);
        System.out.println(list);
    }
    @Test
    public void testSearchByIndex(){
      //  String name = (String) redisTemplate.boundListOps("list").index(0);
        redisTemplate.boundListOps("list").remove(2,"jiao");
        List list = redisTemplate.boundListOps("list").range(0, 10);
        System.out.println(list);
    }
    @Test
    public void setMap(){
        redisTemplate.boundHashOps("map").put("a","AAA");
        redisTemplate.boundHashOps("map").put("b","BBB");
        redisTemplate.boundHashOps("map").put("c","CCC");

    }
    @Test
    public void getMap(){
        Set keys = redisTemplate.boundHashOps("map").keys();
        System.out.println(keys);
        Map entries = redisTemplate.boundHashOps("map").entries();
        System.out.println(entries);
        List values = redisTemplate.boundHashOps("map").values();
        System.out.println(values);
    }

}
