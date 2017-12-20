package com.millsofmn.javabasics.collections;

import java.util.HashSet;
import java.util.Set;

public class JoinSetsExample {

    public static void main(String[] args){

        Set<String> setA = new HashSet<>();
        setA.add("Item 1");
        setA.add("Item 2");

        Set<String> setB = new HashSet<>();
        setB.add("Item 2");
        setB.add("Item 3");

        Set<String> combinedSet = new HashSet<>();
        combinedSet.addAll(setA);
        combinedSet.addAll(setB);

        System.out.println("setA:" + setA);
        System.out.println("setB:" + setB);
        System.out.println("combinedSet:" + combinedSet);
    }
}
