package Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        map.put(1, 2);
        map.put(2, 4);
        map.put(3, 6);

        //entrySet() 方法返回映射中包含的映射的 Set 视图。
        System.out.println(map.keySet());//[0, 1, 2, 3]
        System.out.println(map.values());//[0, 2, 4, 6]

        System.out.println(map.entrySet());//[0=0, 1=2, 2=4, 3=6]

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(entry.getClass());
        }
    }
}
