package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeC {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        Map<String, Integer> collectionB = new HashMap();

        for (String s : collectionA) {
            if (collectionB.containsKey(s)) {
                collectionB.put(s, collectionB.get(s)+1);
            } else {
                collectionB.put(s, 1);
            }
        }
        return new PracticeB().createUpdatedCollection(collectionB, object);
    }
}
