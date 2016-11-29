package design.observer;

/** 
 * @Description 主题
 * 主题改变的时候就要通知观察者 
 * @ClassName   Subject 
 * @Date        2016年9月12日 下午10:05:22 
 * @Author      dongnao.jack 
 */

public interface Subject {
    
    void add(Observer o);
    
    void notifyAllObserver();
}
