package com.millsofmn.javabasics.collections;

import java.util.HashSet;
import java.util.Set;

public class SetsRemoveDuplicates {
    public static void main(String[] args) {
        // define set 1
        Set<String> set1 = new HashSet<String>();
        set1.add("user1");
        set1.add("user2");
        set1.add("user3");
        set1.add("user4");
        set1.add("user5");

        print("Set 1 Before", set1);

        // define set 2
        Set<String> set2 = new HashSet<String>();
        set2.add("user5");
        set2.add("user6");
        set2.add("user7");
        set2.add("user8");
        set2.add("user9");

        print("Set 2 Before", set2);

        // define set 3 and add the duplicates
        Set<String> set3 = new HashSet<>(set1);
        set3.retainAll(set2);

        print("Set 3 Retain All", set3);

        // remove the duplicates from set 2
        set2.removeAll(set3);
        print("Set 1 After", set1);
        print("Set 2 After", set2);

    }

    public static void print(String setName, Set<String> set){
        System.out.println("== " + setName + " ==");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
    }
}
