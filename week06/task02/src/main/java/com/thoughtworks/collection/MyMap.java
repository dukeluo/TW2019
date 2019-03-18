package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.Collections;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    private static String tenToTwentySixBaseOne(int n) {
        String str = "";
        int m;

        while (n > 0) {
            m = n%26 == 0 ? 26 : n%26;
            str = (char) (m+96) + str;
            n = (n-m) / 26;
        }
        return str;
    }

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream()
                         .map(n -> n*3)
                         .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.mapLetters();
    }

    public List<String> mapLetters() {
        return this.array.stream()
                .map(MyMap::tenToTwentySixBaseOne)
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        List<Integer> resultList = this.sortFromSmall();

        Collections.reverse(resultList);
        return resultList;
    }

    public List<Integer> sortFromSmall() {
        return this.array.stream()
                         .sorted()
                         .collect(Collectors.toList());
    }
}
