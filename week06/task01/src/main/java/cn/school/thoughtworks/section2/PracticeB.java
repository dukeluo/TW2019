package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeB {
    Map<String, Integer> countSameElements(List<String> collection1) {
        Map<String, Integer> countMap = new HashMap();
        int index;

        for (String str : collection1) {
            index = str.indexOf("-");
            if (index != -1) {
                countMap.put(str.substring(0, index), Integer.parseInt(str.substring(index+1)));
            } else if (countMap.containsKey(str)) {
                countMap.put(str, countMap.get(str)+1);
            } else {
                countMap.put(str, 1);
            }
        }
        return countMap;
    }
}
