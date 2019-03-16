package com.thoughtworks.collection;

public interface SingleLink<T> {
    public void addTailPointer(T item);         //添加尾指针
    public T getNode(int index);
}