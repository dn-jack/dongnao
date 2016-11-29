package design.responsibility;

public class Jiangxi extends AbstractAction {
    
    public static String type = "江西";
    
    public void todo(String type) {
        
        if (Jiangxi.type.equals(type)) {
            System.out.println("我是江西处理中心，我只处理江西业务！");
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
