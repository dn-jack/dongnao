package design.responsibility;

public class Guangdong extends AbstractAction {
    
    public static String type = "�㶫";
    
    public void todo(String type) {
        
        if (Guangdong.type.equals(type)) {
            System.out.println("���ǹ㶫�������ģ���ֻ����㶫ҵ��");
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
