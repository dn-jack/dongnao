package design.responsibility;

public class Hunan extends AbstractAction {
    
    public static String type = "湖南";
    
    public void todo(String type) {
        
        if (Hunan.type.equals(type)) {
            System.out.println("我是湖南处理中心，我只处理湖南业务！");
        }
        else {
            Action action = this.getAction();
            
            if (action != null) {
                action.todo(type);
            }
            else {
                super.todo(type);
            }
        }
    }
    
}
