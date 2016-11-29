package design.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObserver implements Subject {
    
    List<Observer> obLists = new ArrayList<Observer>();
    
    public void add(Observer o) {
        obLists.add(o);
    }
    
    public void notifyAllObserver() {
        if (obLists.size() <= 0) {
            return;
        }
        for (Observer o : obLists) {
            o.notifyme("�����ݸ��£��뼰ʱ����");
        }
    }
}
