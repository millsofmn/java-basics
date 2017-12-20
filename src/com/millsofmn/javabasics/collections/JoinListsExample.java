package com.millsofmn.javabasics.collections;

import java.util.ArrayList;
import java.util.List;

public class JoinListsExample {

    public static void main(String[] args){

        List<String> listA = new ArrayList<>();
        listA.add("Item 1");
        listA.add("Item 2");

        List<String> listB = new ArrayList<>();
        listB.add("Item 2");
        listB.add("Item 3");

        List<String> combinedList = new ArrayList<>();
        combinedList.addAll(listA);
        combinedList.addAll(listB);

        for(String s : combinedList){
            System.out.println(s);
        }

    }
}
