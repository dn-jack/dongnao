package design.strategy;

public interface Action {
    
    void todo();
    
    /** 
     * @Description �ж��Ƿ����ҵ����� 
     * @param @param type ���� 
     * @return void ��������  
     * @throws 
     */
    
    boolean isMyJob(String type);
}
