package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        Map<String, Integer> countMap = new HashMap();

        for (String s : collection1) {
            if (s.length() != 1) {
                multiCharsHandler(s, countMap);
            } else {
                increaseCount(s, 1, countMap);
            }
        }
        return countMap;
    }

    public static void multiCharsHandler(String s, Map<String, Integer> map) {
        int index;
        int auxIndex;

        if (s.contains("-")) {
            index = s.indexOf("-");
            increaseCount(s.substring(0, index), Integer.parseInt(s.substring(index+1)), map);
        } else if (s.contains(":")) {
            index = s.indexOf(":");
            increaseCount(s.substring(0, index), Integer.parseInt(s.substring(index+1)), map);
        } else if (s.contains("[") && s.contains("]")) {
            index = s.indexOf("[");
            auxIndex = s.indexOf("]");
            increaseCount(s.substring(0, index), Integer.parseInt(s.substring(index+1, auxIndex)), map);
        }
    }

    public static void increaseCount(String item, int num, Map<String, Integer> map) {
        if (map.containsKey(item)) {
            map.put(item, map.get(item)+num);
        } else {
            map.put(item, num);
        }
    }
}
