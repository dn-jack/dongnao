package design.strategy;

public class Hunan extends AbstractAction {
    
    public static String type = "����";
    
    public boolean isMyJob(String type) {
        return Hunan.type.equals(type);
    }
    
    public void todo() {
        System.out.println("���Ǻ��ϴ������ģ���ֻ�������ҵ��");
    }
    
    //    public void todo(String type) {
    //        
    //        if (Hunan.type.equals(type)) {
    //            System.out.println("���Ǻ��ϴ������ģ���ֻ�������ҵ��");
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
