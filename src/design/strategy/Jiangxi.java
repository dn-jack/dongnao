package design.strategy;

public class Jiangxi extends AbstractAction {
    
    public static String type = "����";
    
    public boolean isMyJob(String type) {
        return Jiangxi.type.equals(type);
    }
    
    public void todo() {
        System.out.println("���Ǻ����������ģ���ֻ�������ҵ��");
    }
    
    //    public void todo(String type) {
    //        
    //        if (Jiangxi.type.equals(type)) {
    //            System.out.println("���ǽ����������ģ���ֻ������ҵ��");
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
