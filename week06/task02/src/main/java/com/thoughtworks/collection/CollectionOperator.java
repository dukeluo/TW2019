package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.*;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        boolean flag = left > right;
        List<Integer> resultList = new ArrayList<Integer>();
        int temp;

        if (flag) {
            temp = left;
            left = right;
            right = temp;
        }
        for (int i = left; i < right+1; i++) {
            resultList.add(i);
        }
        if (flag) {
            Collections.reverse(resultList);
        }
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return this.getListByInterval(left, right)
                   .stream()
                   .filter(n -> n%2 == 0)
                   .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return IntStream.of(array)
                        .filter(n -> n%2 == 0)
                        .boxed()
                        .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> resultList = IntStream.of(firstArray)
                                            .boxed()
                                            .collect(Collectors.toList());

        resultList.retainAll(IntStream.of(secondArray).boxed().collect(Collectors.toList()));
        return resultList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> resultList = new ArrayList<Integer>(Arrays.asList(firstArray));

        resultList.addAll(Arrays.asList(secondArray));
        return resultList.stream()
                         .distinct()
                         .collect(Collectors.toList());
    }
}
