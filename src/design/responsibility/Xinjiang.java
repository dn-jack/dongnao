package design.responsibility;

public class Xinjiang extends AbstractAction {
    public static String type = "新疆";
    
    public void todo(String type) {
        
        if (Xinjiang.type.equals(type)) {
            System.out.println("我是新疆处理中心，我只处理新疆业务！");
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
