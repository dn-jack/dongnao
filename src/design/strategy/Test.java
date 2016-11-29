package design.strategy;

import java.util.HashMap;
import java.util.Map;

public class Test {
    
    public static void main(String[] args) {
        
        String type = "����";
        
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
        map.put("����", hunan);
        map.put("����", jx);
        map.put("�㶫", gd);
        map.put("����", hubei);
        
        Action action = (Action)map.get("�㶫");
        
        action.todo();
        
        //        hunan.setAction(hubei);
        //        hubei.setAction(jx);
        //        jx.setAction(gd);
        //        gd.setAction(xj);
        //        xj.setAction(null);
        
        //        hunan.todo("�½�");
    }
}
