package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        Map<String, Integer> map = new HashMap(collectionA);

        for (String str : object.get("value")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str)-map.get(str)/3);
            }
        }
        return map;
    }
}
