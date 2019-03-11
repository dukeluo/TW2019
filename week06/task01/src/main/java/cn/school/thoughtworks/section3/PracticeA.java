package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeA {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        Map<String, Integer> map = new HashMap(collectionA);

        for (String s : object.get("value")) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s)-1);
            }
        }
        return map;
    }
}
