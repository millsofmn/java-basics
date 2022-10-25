package com.millsofmn.codility.practice;

// Write a function solution that, given an integer N, returns the maximum possible value obtainable by deleting
// one '5' digit from the decimal representation of N. It is guaranteed that N will contain at least one '5' digit.
//
// Write a function:
//   class Solution { public int solution(int N); }
//
// Examples:
//   1. Given N = 15958, the function should return 1958.
//   2. Given N = −5859, the function should return −589.
//   3. Given N = −5000, the function should return 0. After deleting the '5', the only digits in the number are
//      zeroes, so its value is 0.
//
// Assume that:
//   N is an integer within the range [−999,995..999,995]
//   N contains at least one '5' digit in its decimal representation
//   N consists of at least two digits in its decimal representation.
//
// In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
public class Remove5 {
    public static void main(String[] args) {
        System.out.println("1958 > " + new Remove5().solution(15958));
        System.out.println("-589 > " + new Remove5().solution(-5859));
        System.out.println("-0 > " + new Remove5().solution(-5000));
    }

    public int solution(int N){
        int largest = Integer.MIN_VALUE;
        String str = ("" + N);
        String temp;

        int loc = str.indexOf("5");

        while(loc > -1){
            temp = str.substring(0, loc) + str.substring(loc+1);
            int number = Integer.parseInt(temp);

            if(number > largest){
                largest = number;
            }

            loc = str.indexOf("5", loc+1);
        }

        return largest;
    }
}
