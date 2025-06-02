package HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 95);

        System.out.println(map.get("Karan"));
        System.out.println(map.getOrDefault("Apoorv", 99));
        System.out.println(map);
        System.out.println(map.containsKey("Kunal"));
        System.out.println(map.containsValue(98));


        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(16);
        set.add(5);
        set.add(56);
        //set.addAll(new int[]{1,2,3});
        System.out.println(set);


        TreeMap<String, Integer> t = new TreeMap<>();
        t.put("Kunal", 89);
        t.put("Karan", 99);
        t.put("Rahul", 95);

        System.out.println(t);//sort on the basis of key

    }
}
