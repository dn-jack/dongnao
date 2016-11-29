package design.responsibility;

public abstract class AbstractAction implements Action {
    
    public Action action;
    
    public void todo(String type) {
        System.out.println("我是你们的爹，你们处理不了，就我来处理！");
    }
    
    public Action getAction() {
        return action;
    }
    
    public void setAction(Action action) {
        this.action = action;
    }
}
