package design.adapter.objectadapter;

public class Test {
    
    public static void main(String[] args) {
        AdapterInft intf = new Adapter(new Source());
        
        intf.method1();
        
        intf.method2();
    }
    
}
