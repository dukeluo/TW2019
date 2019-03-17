package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        return this.array.stream()
                         .filter(n -> n%2 == 0)
                         .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return this.array.stream()
                         .filter(n -> n%3 == 0)
                         .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return this.array.stream()
                   .distinct()
                   .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream()
                        .filter(secondList::contains)
                        .collect(Collectors.toList());
    }
}