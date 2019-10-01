package com.millsofmn.javabasics.codefight.arcade;


public class SumOfDivisors {
    public static void main(String[] args) {
        SumOfDivisors s = new SumOfDivisors();

        System.out.println(s.sumOfDivisors(-44));
        System.out.println(s.sumOfDivisors(12)); // 28
        System.out.println(s.sumOfDivisors(1000000000)); // 28
    }

    // overflow
//    int sumOfDivisors(int n) {
//        int total = 0;
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) total += i;
//        }
//        return Math.abs(total);
//    }

//    int sumOfDivisors(int n) {
//        int c = 0;
//        for (char d : ("" + n).toCharArray())
//            if ((int) d % 2 == 0) c++;
//
//
//        return c;
//    }

    int sumOfDivisors(int n) {
        return (int)("" + n).chars().filter(x->x % 2 < 1).count();
    }
}
