package design.observer;

public class Observer1 implements Observer {
    
    public void notifyme(String msg) {
        System.out.println("我是观察者1，我收到了消息" + msg);
    }
}
