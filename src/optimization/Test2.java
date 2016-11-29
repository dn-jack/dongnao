package optimization;

public class Test2 {
    
    public static void main(String[] args) {
        ClassTest1 ct1 = new ClassTest1();
        ClassTest2 ct2 = new ClassTest2();
        
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 90000; i++) {
            ct1.getName();
        }
        Long t2 = System.currentTimeMillis();
        for (int i = 0; i < 90000; i++) {
            ct2.getName();
        }
        Long t3 = System.currentTimeMillis();
        System.out.println("加了final修饰:" + (t2 - t1));
        System.out.println("没加final修饰:" + (t3 - t2));
    }
    
}
