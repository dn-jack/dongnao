package design.strategy;

public class Hubei extends AbstractAction {
    
    public static String type = "����";
    
    public boolean isMyJob(String type) {
        return Hubei.type.equals(type);
    }
    
    public void todo() {
        System.out.println("���Ǻ����������ģ���ֻ�������ҵ��");
    }
    
    //    public void todo(String type) {
    //        
    //        if (Hubei.type.equals(type)) {
    //            System.out.println("���Ǻ����������ģ���ֻ�������ҵ��");
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
