package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        Map<String, Integer> countMap = new HashMap();

        for (String str : collection1) {
            if (str.length() != 1) {
                multiCharsHandler(str, countMap);
            } else {
                increaseCount(str, 1, countMap);
            }
        }
        return countMap;
    }

    public static void multiCharsHandler(String str, Map<String, Integer> map) {
        int index;
        int auxIndex;

        if (str.contains("-")) {
            index = str.indexOf("-");
            increaseCount(str.substring(0, index), Integer.parseInt(str.substring(index+1)), map);
        } else if (str.contains(":")) {
            index = str.indexOf(":");
            increaseCount(str.substring(0, index), Integer.parseInt(str.substring(index+1)), map);
        } else if (str.contains("[") && str.contains("]")) {
            index = str.indexOf("[");
            auxIndex = str.indexOf("]");
            increaseCount(str.substring(0, index), Integer.parseInt(str.substring(index+1, auxIndex)), map);
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
