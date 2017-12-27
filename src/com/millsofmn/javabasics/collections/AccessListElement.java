package com.millsofmn.javabasics.collections;

import java.util.ArrayList;
import java.util.List;

public class AccessListElement {

    public static void main(String[] args){
        int listSize = 53;
        List<String> myList = new ArrayList<>(50);

        for(int i = 0; i < listSize; i++){
            myList.add("Item " + i);
        }

        System.out.println("My list size is '" + myList.size() + "'");
        System.out.println("First list item is '" + myList.get(0) + "'");
        System.out.println("Middle list item is '" + myList.get(myList.size()/2));
        System.out.println("Last list item is '" + myList.get(myList.size() -1) + "'");
    }
}
