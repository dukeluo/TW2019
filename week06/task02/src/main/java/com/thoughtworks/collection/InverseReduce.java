package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.*;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int d = this.random.nextInt(3);

        return Stream.iterate(number-d, n -> n-d)
                     .limit(number/d)
                     .collect(Collectors.toList());
    }
}
