package design.adapter.objectadapter;

public class Adapter implements AdapterInft {
    
    Source source;
    
    public Adapter(Source source) {
        this.source = source;
    }
    
    public void method1() {
        source.method1();
    }
    
    public void method2() {
        System.out.println("�ڶ��ڵĹ�����չ����Ҫ��չ���ܣ�");
    }
}
