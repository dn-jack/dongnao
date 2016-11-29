package design.observer;

public class Observer2 implements Observer {
    
    public void notifyme(String msg) {
        System.out.println("我是观察者2，我收到了消息" + msg);
    }
}
