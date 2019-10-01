package com.millsofmn.javabasics.codefight.arcade;

import java.util.stream.IntStream;

public class AreSimilar {

    public static void main(String[] args) {
        AreSimilar a = new AreSimilar();

        int[] aA = new int[]{1,2,3};
        int[] bA = new int[]{2,1,3};
        boolean expectedA = true;
        boolean actualA = a.areSimilar(aA, bA);
        System.out.println("Expected: " + expectedA + " Actual: " + actualA);

        int[] aB = new int[]{4, 6, 3};
        int[] bB = new int[]{3, 4, 6};
        boolean expectedB = false;
        boolean actualB = a.areSimilar(aB, bB);
        System.out.println("Expected: " + expectedB + " Actual: " + actualB);

        int[] aC = new int[]{1, 2, 2};
        int[] bC = new int[]{2, 1, 1};
        boolean expectedC = false;
        boolean actualC = a.areSimilar(aC, bC);
        System.out.println("Expected: " + expectedC + " Actual: " + actualC);
    }

    boolean areSimilar(int[] a, int[] b) {
        int swap = 0;
        for(int i = 0; i < a.length; i++){
            if(i+1 < a.length && (a[i] == b[i+1] || b[i] == a[i+1])){
                    swap++;
            }
        }
        return (swap <= 1);
    }

}
