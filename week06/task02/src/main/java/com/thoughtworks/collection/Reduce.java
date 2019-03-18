package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream()
                             .mapToInt(Integer::intValue)
                             .summaryStatistics()
                             .getMax();
    }

    public double getMinimum() {
        return this.arrayList.stream()
                             .mapToInt(Integer::intValue)
                             .summaryStatistics()
                             .getMin();
    }

    public double getAverage() {
        return this.arrayList.stream()
                             .mapToInt(Integer::intValue)
                             .summaryStatistics()
                             .getAverage();
    }

    public double getOrderedMedian() {
        int[] evens = this.arrayList.stream()
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

    public Double getMedianInLinkList(SingleLink singleLink) {
        int length = this.arrayList.size();

        for (int i = 0; i < length; i++) {
            singleLink.addTailPointer(this.arrayList.get(i));
        }
        if (length%2 == 0) {
            return ((Integer) singleLink.getNode(length/2) + (Integer) singleLink.getNode(length/2+1)) / 2.0;
        } else {
            return (Integer) singleLink.getNode(length/2+1) + 0.0;
        }
    }

    public int getFirstEven() {
        int even = -1;

        for (int i = 0; i < this.arrayList.size(); i++) {
            if (this.arrayList.get(i) % 2 == 0) {
                even = this.arrayList.get(i);
                break;
            }
        }
        return even;
    }

    public int getIndexOfFirstEven() {
        int index = -1;

        for (int i = 0; i < this.arrayList.size(); i++) {
            if (this.arrayList.get(i) % 2 == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int getLastOdd() {
        int odd = 0;

        for (int i = this.arrayList.size()-1; i >= 0; i--) {
            if (this.arrayList.get(i) % 2 != 0) {
                odd = this.arrayList.get(i);
                break;
            }
        }
        return odd;
    }

    public int getIndexOfLastOdd() {
        int index = -1;

        for (int i = this.arrayList.size()-1; i >= 0; i--) {
            if (this.arrayList.get(i) % 2 != 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList.equals(this.arrayList);
    }
}
