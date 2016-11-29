package design.responsibility;

public class Hubei extends AbstractAction {
    
    public static String type = "����";
    
    public void todo(String type) {
        
        if (Hubei.type.equals(type)) {
            System.out.println("���Ǻ����������ģ���ֻ�������ҵ��");
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
