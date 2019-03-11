package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        Map<String, Integer> countMap = new HashMap();

        for (String s : collection1) {
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s)+1);
            } else {
                countMap.put(s, 1);
            }
        }
        return countMap;
    }
}
