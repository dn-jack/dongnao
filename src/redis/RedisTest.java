package redis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RedisTest {
    
    @Test
    public void setget() {
        RedisApi.set("dongnao-star", "star");
        
        System.out.println(RedisApi.get("dongnao-star"));
    }
    
    @Test
    public void lpushlrange() {
        RedisApi.lpush("lpush", new String[] {"star", "jack", "jason"});
        
        System.out.println(RedisApi.lrange("lpush"));
    }
    
    @Test
    public void hmsethmget() {
        
        Map map = new HashMap();
        map.put("jack", "jack1");
        map.put("sam", "sam");
        map.put("senvon", "senvon");
        
        RedisApi.hmset("map", map);
        
        System.out.println(RedisApi.hmget("map", "jack"));
    }
    
    public static void main(String[] args) {
        int i = 0;
        i++;
        ++i;
        System.out.print(i);
    }
}
