package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int temp;

        if (leftBorder > rightBorder) {
            temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        return IntStream.range(leftBorder, rightBorder+1)
                        .filter(n -> n%2 == 0)
                        .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int temp;

        if (leftBorder > rightBorder) {
            temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        return IntStream.range(leftBorder, rightBorder+1)
                        .filter(n -> n%2 != 0)
                        .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                        .mapToInt(Integer::intValue)
                        .map(n -> n*3+2)
                        .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                        .map(n -> n%2 == 0 ? n : 3*n+2)
                        .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                        .mapToInt(Integer::intValue)
                        .map(n -> n%2 == 0 ? 0 : 3*n+5)
                        .sum();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> resultList = new ArrayList<Integer>();

        for (int i = 1; i < arrayList.size(); i++) {
            resultList.add((arrayList.get(i)+arrayList.get(i-1))*3);
        }
        return resultList;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        int[] evens = arrayList.stream()
                               .filter(n -> n%2 == 0)
                               .mapToInt(Integer::intValue)
                               .sorted()
                               .toArray();
        int length = evens.length;

        if (length % 2 == 0) {
            return (evens[length/2]+evens[length/2-1]) / 2.0;
        } else {
            return evens[length/2] + 0.0;
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                        .filter(n -> n%2 == 0)
                        .mapToInt(Integer::intValue)
                        .average()
                        .getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                        .filter(n -> n%2 == 0)
                        .collect(Collectors.toList())
                        .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                        .filter(n -> n%2 == 0)
                        .distinct()
                        .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evens = arrayList.stream()
                                       .filter(n -> n%2 == 0)
                                       .collect(Collectors.toList());
        List<Integer> odds = arrayList.stream()
                                       .filter(n -> n%2 != 0)
                                       .collect(Collectors.toList());

        evens.sort((a, b) -> a - b);
        odds.sort((a, b) -> b - a);
        evens.addAll(odds);
        return evens;
    }
}
