package design.responsibility;

public abstract class AbstractAction implements Action {
    
    public Action action;
    
    public void todo(String type) {
        System.out.println("�������ǵĵ������Ǵ����ˣ�����������");
    }
    
    public Action getAction() {
        return action;
    }
    
    public void setAction(Action action) {
        this.action = action;
    }
}
