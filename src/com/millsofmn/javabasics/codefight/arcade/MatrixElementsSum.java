package com.millsofmn.javabasics.codefight.arcade;

import java.util.ArrayList;
import java.util.List;

public class MatrixElementsSum {


    public static void main(String[] args) {

        int[][] matrix1 = {{0,1,1,2},{0,5,0,0},{2,0,3,3}};
        int expectedResult1 = 9;
        int actualResult1 = matrixElementsSum(matrix1);
        System.out.println("Test 1 = " + (expectedResult1 == actualResult1));

        int[][] matrix2 = {{1,1,1,0},{0,5,0,1},{2,1,3,10}};
        int expectedResult2 = 9;
        int actualResult2 = matrixElementsSum(matrix2);
        System.out.println("Test 2 = " + (expectedResult2 == actualResult2));

        int[][] matrix3 = {{1,1,1},{2,2,2},{3,3,3}};
        int expectedResult3 = 18;
        int actualResult3 = matrixElementsSum(matrix3);
        System.out.println("Test 3 = " + (expectedResult3 == actualResult3));

        int[][] matrix4 = {{0}};
        int expectedResult4 = 0;
        int actualResult4 = matrixElementsSum(matrix4);
        System.out.println("Test 4 = " + (expectedResult4 == actualResult4));



    }

    private static int matrixElementsSum(int[][] matrix){
        int sum = 0;
        List<Integer> haunted = new ArrayList<>();
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                if(matrix[row][col] != 0 && !haunted.contains(col)){
                    sum+=matrix[row][col];
                } else {
                    haunted.add(col);
                }
            }
        }
        return sum;
    }

}
