package com.millsofmn.javabasics.codefight.arcade;

public class ShapeArea {

    public static void main(String[] args){
        int result1 = shapeArea(2);
        assertThat(2, 5, result1);

        int result2 = shapeArea(3);
        assertThat(3, 13, result2);

        int result3 = shapeArea(1);
        assertThat(1, 1, result3);

        int result4 = shapeArea(5);
        assertThat(5, 41, result4);

    }

    static int shapeArea(int n) {
        int outerRow = n * n;
        int innerRow = (n-1) * (n-1);
        return  outerRow + innerRow;
    }

    static void assertThat(int input, int expected, int actual){
        if(expected == actual){
            System.out.println("Area of polygon " + input + " is " + actual);
        } else {
            System.err.println("Results Area of polygon " + input + " is " + actual + " but really is " + expected);
        }
    }
}
