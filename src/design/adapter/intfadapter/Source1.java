package design.adapter.intfadapter;

public class Source1 extends Wrapper {
    
    public void method1() {
        System.out.println("我只关心method1");
    }
    
    public void method2() {
        System.out.println("我只关心method2");
    }
}
