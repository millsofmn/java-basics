package com.millsofmn.javabasics.codefight.arcade;

import java.util.ArrayList;

public class HeadToHeadScratchPaper {

    public static void main(String[] args) {
//        System.out.println("10 " + digitsProduct(0));
//        System.out.println("8760 " + reverseBits(7236));
        System.out.println("2 " + parabole(1, 2, 3, -1));
    }

    static int parabole(int a, int b, int c, int x) {

        int sqrtX = x * x;
        int bx = b * x;
        return (a * (int)sqrtX) + (b*x) + c;
    }
    static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 16; i++) {
            res = reverseBits(n);
            n /= 2;
        }
        return res;
    }

    static int digitsProduct(int product) {
        ArrayList<Integer> answerDigits = new ArrayList<>();
        int answer = 0;

        if (product == 0) {
            return 0;
        }

        if (product == 1) {
            return 1;
        }

        for (int divisor = 9; divisor > 1; divisor--) {
            while (product % divisor == 0) {
                product /= divisor;
                answerDigits.add(divisor);
            }
        }

        if (product > 1) {
            return -1;
        }


        for (int i = answerDigits.size() - 1; i >= 0; i--) {
            answer = 10 * answer + answerDigits.get(i);
        }
        return answer;
    }
}
