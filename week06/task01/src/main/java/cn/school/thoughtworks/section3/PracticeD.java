package cn.school.thoughtworks.section3;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        Map<String, Integer> collectionB = new HashMap();
        int index;

        for (String s : collectionA) {
            index = s.indexOf("-");
            if (index != -1) {
                collectionB.put(s.substring(0, index), Integer.parseInt(s.substring(index+1)));
            } else if (collectionB.containsKey(s)) {
                collectionB.put(s, collectionB.get(s)+1);
            } else {
                collectionB.put(s, 1);
            }
        }
        return new PracticeB().createUpdatedCollection(collectionB, object);
    }
}
