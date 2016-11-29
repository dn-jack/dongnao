package design.observer;

/** 
 * @Description ����
 * ����ı��ʱ���Ҫ֪ͨ�۲��� 
 * @ClassName   Subject 
 * @Date        2016��9��12�� ����10:05:22 
 * @Author      dongnao.jack 
 */

public interface Subject {
    
    void add(Observer o);
    
    void notifyAllObserver();
}
