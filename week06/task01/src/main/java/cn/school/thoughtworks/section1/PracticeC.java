package cn.school.thoughtworks.section1;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class PracticeC {
    List<String> collectSameElements(List<String> collection1, Map<String,List<String>> collection2) {
        List<String> stringList = new ArrayList<String>(collection2.get("value"));
        List<String> intersection = new ArrayList<String>(collection1);

        intersection.retainAll(stringList);
        return intersection;
    }
}
