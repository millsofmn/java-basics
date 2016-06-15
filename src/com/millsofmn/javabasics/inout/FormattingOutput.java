package com.millsofmn.javabasics.inout;

/**
 * Created by m108491 on 6/15/2016.
 */
public class FormattingOutput {

    public static void main(String[] args){
        double x = 10000.0/3.0;

        System.out.println("x=" + x);
        System.out.printf("%8.2f", x);

        System.out.printf("I am going to insert strings %s and %s.", "here", "there");
    }
}
