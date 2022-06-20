package com.millsofmn.codility.iterations;

import java.util.HashMap;
import java.util.Map;

public class BinaryGap {

    public static int binaryGap(int N){
        String testValue = Integer.toBinaryString(N);
//        System.out.println(N + " " + testValue);

        int longestGap = 0;
        int gap = 0;

        for(char i : testValue.toCharArray()){
            if(i == '1'){
                if(gap > longestGap){
                    longestGap = gap;
                }
                gap = 0;

            } else if( i == '0'){
                gap++;
            }

        }
        return longestGap;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> tests = new HashMap<>();
        tests.put(41, 2);
        tests.put(42, 1);
        tests.put(2, 0);
        tests.put(256, 0);
        tests.put(257, 7);

        for(Map.Entry<Integer, Integer> entry: tests.entrySet()){
            checkTest(entry.getKey(), entry.getValue());
        }
    }

    private static void checkTest(int testValue, int expectedResult){
        int actualResult = binaryGap(testValue);

        if(expectedResult == actualResult){
            System.out.println("Test " + testValue + ": PASS");
        } else {
            System.err.println("Test " + testValue + ": FAIL [expected=" + expectedResult +", actual=" + actualResult + "]");
        }
    }

}
