package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.*;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Stream.of(this.array)
                     .flatMap(Stream::of)
                     .collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return this.transformToOneDimesional()
                   .stream()
                   .distinct()
                   .collect(Collectors.toList());
    }
}
