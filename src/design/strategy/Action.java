package design.strategy;

public interface Action {
    
    void todo();
    
    /** 
     * @Description 判断是否是我的任务 
     * @param @param type 参数 
     * @return void 返回类型  
     * @throws 
     */
    
    boolean isMyJob(String type);
}
