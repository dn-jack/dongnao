/** 
 * @Project     dongnao 
 * @File        WeChat.java 
 * @Package     redis 
 * @Version     V1.0 
 * @Date        2016年11月8日 下午9:07:08 
 * @Author      dongnao.jack 
 */

package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/** 
 * @Description TODO 
 * @ClassName   WeChat 
 * @Date        2016年11月8日 下午9:07:08 
 * @Author      dongnao.jack 
 */

public class WeChat extends JedisPubSub {
    
    public void onMessage(String channel, String message) {
        System.out.println(channel + ":" + message);
    }
    
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(channel + ":" + subscribedChannels);
    }
    
    public static void main(String[] args) {
        Jedis je = null;
        try {
            WeChat wc = new WeChat();
            
            je = new Jedis("120.77.22.187", 1000, 0);
            je.auth("123");
            //            je.set(key, value);
            wc.proceed(je.getClient(), "dongnao-java");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (je != null) {
                je.disconnect();
            }
        }
    }
}
