package Redis;

import com.jc.entity.Teacher;
import com.jc.tool.RedisSerializableUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {
    @Test
    public void redis(){
        Jedis  jedis=new Jedis("192.168.1.100",6379);
        jedis.set("name","xiao");
        System.out.println(jedis.get("name"));
    }
    @Test
    public void redisPool(){
        JedisPool jedisPool=new JedisPool("192.168.1.100",6379);
        Jedis jedis=jedisPool.getResource();
        jedis.set("name","ye");
        System.out.println(jedis.get("name"));
        jedis.close();
    }
//    @Test
//    public void redisSpring(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
//        JedisPool jedisPool=(JedisPool)applicationContext.getBean("jedisPool");
//        Jedis jedis=jedisPool.getResource();
//        jedis.set("name","xiao");
//        System.out.println(jedis.get("name"));
//        jedis.close();
//    }
    @Test
    public void redisHash(){
        Jedis jedis=new Jedis("192.168.1.100",6379);
        Teacher tea=new Teacher();
        tea.setSex("nan");
        tea.setTname("xiaohong");
        try {
            jedis.set("01".getBytes(), RedisSerializableUtil.serialize(tea));
            byte[] a=jedis.get("01".getBytes());
            Teacher t=(Teacher)RedisSerializableUtil.unserizlize(a);
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
