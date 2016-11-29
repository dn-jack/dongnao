/** 
 * @Project     dongnao 
 * @File        DNPubSub.java 
 * @Package     redis 
 * @Version     V1.0 
 * @Date        2016年11月7日 下午4:40:04 
 * @Author      dongnao.jack 
 */

package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/** 
 * @Description TODO 
 * @ClassName   DNPubSub 
 * @Date        2016年11月7日 下午4:40:04 
 * @Author      dongnao.jack 
 */

public class DNPubSub extends JedisPubSub {
    
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel + ":" + message);
    }
    
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        // TODO Auto-generated method stub
        super.onPMessage(pattern, channel, message);
    }
    
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println(channel + ":" + subscribedChannels);
    }
    
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        // TODO Auto-generated method stub
        super.onUnsubscribe(channel, subscribedChannels);
    }
    
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        super.onPUnsubscribe(pattern, subscribedChannels);
    }
    
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        super.onPSubscribe(pattern, subscribedChannels);
    }
    
    @Override
    public void unsubscribe() {
        // TODO Auto-generated method stub
        super.unsubscribe();
    }
    
    @Override
    public void unsubscribe(String... channels) {
        // TODO Auto-generated method stub
        super.unsubscribe(channels);
    }
    
    @Override
    public void subscribe(String... channels) {
        // TODO Auto-generated method stub
        super.subscribe(channels);
    }
    
    @Override
    public void psubscribe(String... patterns) {
        // TODO Auto-generated method stub
        super.psubscribe(patterns);
    }
    
    @Override
    public void punsubscribe() {
        // TODO Auto-generated method stub
        super.punsubscribe();
    }
    
    @Override
    public void punsubscribe(String... patterns) {
        // TODO Auto-generated method stub
        super.punsubscribe(patterns);
    }
    
    public static void main(String[] args) {
        Jedis jr = new Jedis("120.77.22.187", 6379, 0);
        
        DNPubSub ps = new DNPubSub();
        ps.proceed(jr.getClient(), "dongnao");
    }
    
}
