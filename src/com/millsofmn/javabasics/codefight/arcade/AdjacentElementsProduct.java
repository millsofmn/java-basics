package com.millsofmn.javabasics.codefight.arcade;

// adjacent = next to or adjoining
public class AdjacentElementsProduct {

    public static void main(String[] args){

        int[] inputArray = new int[]{3, 6, -2, -5, 7, 3};
        int result = adjacentElementsProduct(inputArray);
        System.out.println(result);
    }

    private static int adjacentElementsProduct(int[] inputArray){
        int last = inputArray[0];
        int highest = Integer.MIN_VALUE;

        for(int i = 1; i < inputArray.length; i++){
            int result = last * inputArray[i];
            if(result > highest){
                highest = result;
            }
            last = inputArray[i];
        }

        return highest;
    }
}
