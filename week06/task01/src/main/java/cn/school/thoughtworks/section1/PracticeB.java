package cn.school.thoughtworks.section1;

import java.util.List;
import java.util.ArrayList;

public class PracticeB {
    List<String> collectSameElements(List<String> collection1, List<List<String>> collection2) {
        List<String> stringList = new ArrayList<String>();
        List<String> intersection = new ArrayList<String>(collection1);

        for (List<String> list : collection2) {
            stringList.addAll(list);
        }
        intersection.retainAll(stringList);
        return intersection;
    }
}
