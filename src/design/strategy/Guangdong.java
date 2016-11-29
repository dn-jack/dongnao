package design.strategy;

public class Guangdong extends AbstractAction {
    
    public static String type = "广东";
    
    public boolean isMyJob(String type) {
        return Guangdong.type.equals(type);
    }
    
    public void todo() {
        System.out.println("我是广东处理中心，我只处理广东业务！");
    }
    
    //    public void todo(String type) {
    //        
    //        if (Guangdong.type.equals(type)) {
    //            System.out.println("我是广东处理中心，我只处理广东业务！");
    //        }
    //        else {
    //            Action action = this.getAction();
    //            
    //            if (action != null) {
    //                action.todo(type);
    //            }
    //            else {
    //                super.todo(type);
    //            }
    //        }
    //    }
    
}
