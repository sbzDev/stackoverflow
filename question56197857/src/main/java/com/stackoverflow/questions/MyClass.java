package com.stackoverflow.questions;

import java.util.*;
import java.util.stream.Collectors;


public class MyClass {
    private String propertyOne;

    private String propertyTwo;

    public MyClass(String propertyOne, String propertyTwo) {
        this.propertyOne = propertyOne;
        this.propertyTwo = propertyTwo;
    }

    public String getPropertyOne() {
        return propertyOne;
    }

    public String getPropertyTwo() {
        return propertyTwo;
    }

    public static void main(String[] args) {
        Collection<MyClass> data = new LinkedList<>();
        data.add(new MyClass("a1", "b1"));
        data.add(new MyClass("a1", "b2"));
        data.add(new MyClass("a2", "b3"));

        Map<String, Set<String>> result =  data.stream()
                .collect(Collectors.groupingBy(
                        MyClass::getPropertyOne,
                        Collectors.mapping(MyClass::getPropertyTwo, Collectors.toSet())
                ));

    }
}
