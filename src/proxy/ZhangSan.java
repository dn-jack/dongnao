package proxy;

public class ZhangSan implements People {
    
    private String aa = "aa";
    
    public void eat() throws Throwable {
        System.out.println("����Է���ʱ��ϲ������Ů������");
    }
    
    public void sleep() throws Throwable {
        
    }
    
    public void sport() throws Throwable {
        
    }
    
    public String getAa() {
        return aa;
    }
    
    public void setAa(String aa) {
        this.aa = aa;
    }
}
