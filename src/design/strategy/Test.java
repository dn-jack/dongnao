package design.strategy;

import java.util.HashMap;
import java.util.Map;

public class Test {
    
    public static void main(String[] args) {
        
        String type = "湖南";
        
        Hunan hunan = new Hunan();
        Hubei hubei = new Hubei();
        Jiangxi jx = new Jiangxi();
        Guangdong gd = new Guangdong();
        
        //        List<Action> lists = new ArrayList<Action>();
        //        lists.add(hunan);
        //        lists.add(hubei);
        //        lists.add(jx);
        //        lists.add(gd);
        
        //        for (Action action : lists) {
        //            if (action.isMyJob(type)) {
        //                action.todo();
        //                break;
        //            }
        //        }
        
        Map map = new HashMap();
        map.put("湖南", hunan);
        map.put("江西", jx);
        map.put("广东", gd);
        map.put("湖北", hubei);
        
        Action action = (Action)map.get("广东");
        
        action.todo();
        
        //        hunan.setAction(hubei);
        //        hubei.setAction(jx);
        //        jx.setAction(gd);
        //        gd.setAction(xj);
        //        xj.setAction(null);
        
        //        hunan.todo("新疆");
    }
}
