package design.responsibility;

public class Hunan extends AbstractAction {
    
    public static String type = "����";
    
    public void todo(String type) {
        
        if (Hunan.type.equals(type)) {
            System.out.println("���Ǻ��ϴ������ģ���ֻ�������ҵ��");
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
