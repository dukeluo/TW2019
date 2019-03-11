package cn.school.thoughtworks.section1;

import java.util.List;
import java.util.ArrayList;

public class PracticeA {
    List<String> collectSameElements(List<String> collection1, List<String> collection2) {
        List<String> intersection = new ArrayList<String>(collection1);

        intersection.retainAll(collection2);
        return intersection;
    }
}
