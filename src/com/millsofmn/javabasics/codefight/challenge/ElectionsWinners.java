package com.millsofmn.javabasics.codefight.challenge;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ElectionsWinners {

    public static void main(String[] args) {
        ElectionsWinners e = new ElectionsWinners();

        int k1 = 3;
        int[] votes1 = new int[]{2, 3, 5, 2};
        int expected1 = 2;
        int result1 = e.electionsWinners(votes1, k1);
        System.out.println(expected1 + " but was " + result1);

        int k2 = 0;
        int[] votes2 = new int[]{1, 3, 3, 1, 1};
        int expected2 = 0;
        int result2 = e.electionsWinners(votes2, k2);
        System.out.println(expected2 + " but was " + result2);

        int k3 = 0;
        int[] votes3 = new int[]{5, 1, 3, 4, 1};
        int expected3 = 1;
        int result3 = e.electionsWinners(votes3, k3);
        System.out.println(expected3 + " but was " + result3);
    }

    int electionsWinners(int[] V, int k) {
        Arrays.sort(V);
        int l=V.length-1, r=0;
        for (int v: V)
            r += v+k>V[l]? 1: 0;
        return r>0? r: V[l]>V[l-1]? 1: 0;
    }
}
