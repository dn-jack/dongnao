package design.responsibility;

public class Test {
    
    public static void main(String[] args) {
        
        Hunan hunan = new Hunan();
        Hubei hubei = new Hubei();
        Jiangxi jx = new Jiangxi();
        Guangdong gd = new Guangdong();
        Xinjiang xj = new Xinjiang();
        
        hunan.setAction(hubei);
        hubei.setAction(jx);
        jx.setAction(gd);
        gd.setAction(xj);
        xj.setAction(null);
        
        hunan.todo("ÐÂ½®");
    }
    
}
