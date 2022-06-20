package com.millsofmn.codility.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A non-empty array A consisting of N integers is given. The array contains
 * an odd number of elements, and each element of the array can be paired with
 * another element that has the same value, except for one element that is
 * left unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above
 * conditions, returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */
public class OddOccurrencesInArray {

    /**
     * Public Solution
     */
    public static int solution(int[]A){
       int solution = 0;
       for(int value: A){
           solution ^= value; // why does this work?
       }
       return solution;
    }

    /**
     * https://app.codility.com/demo/results/training6QQ6G4-W9Q/
     */
    public static int solution3(int[] A){
        Arrays.sort(A);

        for(int i = 0; i < A.length-1; i += 2){
            if(A[i] != A[i+1]){
                return A[i];
            }
        }
        return A[A.length -1];
    }

    public static int solution1(int[] A) {

        List<Integer> values = Arrays.stream(A).boxed().collect(Collectors.toList());
        Set<Integer> checks = new HashSet<>(values);

        for(Integer val : checks){
            Long count = values.stream().filter(v -> val.equals(v)).count();
            if(count%2 >= 1){
                return val;
            } else {
                values.remove(val);
            }
        }
        return -1;
    }

    public static int solution2(int[]A){

        for(int i = 0; i < A.length; i++){
            int check = A[i];
            long count = Arrays.stream(A).filter(value -> value == check).count();
            if(count%2 >= 1){
                return A[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(array1));

        int[] array2 = {9, 3, 9, 3, 9, 7, 9, 7, 9};
        System.out.println(solution(array2));
    }
}
