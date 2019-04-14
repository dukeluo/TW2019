package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        Map<String, Integer> countMap = new HashMap();

        for (String str : collection1) {
            if (countMap.containsKey(str)) {
                countMap.put(str, countMap.get(str)+1);
            } else {
                countMap.put(str, 1);
            }
        }
        return countMap;
    }
}
