package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeB {
    Map<String, Integer> countSameElements(List<String> collection1) {
        Map<String, Integer> countMap = new HashMap();
        int index;

        for (String s : collection1) {
            index = s.indexOf("-");
            if (index != -1) {
                countMap.put(s.substring(0, index), Integer.parseInt(s.substring(index+1)));
            } else if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s)+1);
            } else {
                countMap.put(s, 1);
            }
        }
        return countMap;
    }
}
