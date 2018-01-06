package com.millsofmn.javabasics.codefight.arcade;

import java.util.*;

public class SortByHeight {
    public static void main(String[] args) {
        int[] test1 = new int[] {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] result1 = sortByHeight(test1);

        for(int i : result1){
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private static int[] sortByHeight(int[] a) {
        List<Integer> people = new ArrayList<>();

        for(int i = 0; i < a.length; i++){
            if(a[i] != -1){
                people.add(a[i]);
            }
        }

        Collections.sort(people);
        Iterator<Integer> person = people.iterator();

        int[] photo = new int[a.length];

        for(int x = 0; x < a.length; x++){
            if(a[x] == -1){
                photo[x] = -1;
            } else {
                photo[x] = person.next();
            }
        }

        return photo;
    }

}
