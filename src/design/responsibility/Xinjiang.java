package design.responsibility;

public class Xinjiang extends AbstractAction {
    public static String type = "�½�";
    
    public void todo(String type) {
        
        if (Xinjiang.type.equals(type)) {
            System.out.println("�����½��������ģ���ֻ�����½�ҵ��");
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
