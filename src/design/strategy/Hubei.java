package design.strategy;

public class Hubei extends AbstractAction {
    
    public static String type = "湖北";
    
    public boolean isMyJob(String type) {
        return Hubei.type.equals(type);
    }
    
    public void todo() {
        System.out.println("我是湖北处理中心，我只处理湖北业务！");
    }
    
    //    public void todo(String type) {
    //        
    //        if (Hubei.type.equals(type)) {
    //            System.out.println("我是湖北处理中心，我只处理湖北业务！");
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
