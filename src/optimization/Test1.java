package optimization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        
        int size = list.size();
        
        //ÆÕÍ¨µÄfor
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < size; j++) {
                list.get(j);
            }
        }
        Long t2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            for (Integer obj : list) {
                
            }
        }
        Long t3 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            
        }
        Long t4 = System.currentTimeMillis();
        
        System.out.println("ÆÕÍ¨for£º" + (t2 - t1));
        System.out.println("foreach£º" + (t3 - t2));
        System.out.println("Iterator£º" + (t4 - t3));
        
        list.add(1);
        
    }
}
