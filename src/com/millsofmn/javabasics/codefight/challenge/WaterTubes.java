package com.millsofmn.javabasics.codefight.challenge;

import java.util.stream.IntStream;

public class WaterTubes {

    public static void main(String[] args) {
        WaterTubes w = new WaterTubes();
        int[] water1 = new int[]{1, 2, 5};
        int[] flowPerMinute1 = new int[]{1, 1, 2};
        int expected1 = 3;
        int actual1 = w.waterTubes(water1, flowPerMinute1);
        System.out.println("Result is " + actual1 + " expected " + expected1);

        int[] water2 = new int[]{1, 2, 3};
        int[] flowPerMinute2 = new int[]{1, 1, 2};
        int expected2 = 2;
        int actual2 = w.waterTubes(water2, flowPerMinute2);
        System.out.println("Result is " + actual2 + " expected " + expected2);

        int[] water3 = new int[]{1, 1, 1};
        int[] flowPerMinute3 = new int[]{3, 4, 5};
        int expected3 = 1;
        int actual3 = w.waterTubes(water3, flowPerMinute3);
        System.out.println("Result is " + actual3 + " expected " + expected3);
    }

    int waterTubes2(int[] w, int[] f) {
        int r, h = 0, i = 0;
        for (; i < w.length; i++){ r = (w[i] + f[i] - 1) / f[i]; if (r > h) h = r;}

        return h;
    }

    // winner cheater these were the answers
//    static int r;
//    int waterTubes(int[] w, int[] f) {
//        return new int[]{3,2,1,5,3}[r++];
//    }

    // runner up
//    int r, i;
//    int waterTubes(int[] w, int[] f) {
//        for (int v : w)
//            r = r < (v = 1 + --v / f[i++]) ? v : r;
//        return r;
//    }
//    int m,i;
//    int waterTubes(int[] w, int[] f) {
//        for(int W:w)
//            m=m>(W=--W/f[i++])?m:W;
//        return m+1;
//    }

//    int i, r, t;
//    int waterTubes(int[] W, int[] F)
//    {
//        for (int f : F)
//            r = (t = (W[i++] + f - 1) / f) > r ? t : r;
//        return r;
//    }
//int r, i;
//    int waterTubes(int[] w, int[] f) {
//
//        for (int l : f)
//            r = Math.max(r, (w[i++] + l - 1) / l);
//
//        return r;
//    }
    int waterTubes(int[] w, int[] f) {
    int r=0,t,i=0;
    for (int v:w) {
        t=(v-1)/f[i++]+1;
        r = t > r ? t : r;
    }
    return r;
}
}
