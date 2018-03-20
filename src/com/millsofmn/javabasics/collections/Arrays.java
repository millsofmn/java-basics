package com.millsofmn.javabasics.collections;

public class Arrays {

    public static void main(String[] args) {
        String values1 = "Clinical Validation Verification";
        String[] arrayValues1 = values1.split("\\s+");
        print("String Array", arrayValues1);

        String values2 = "Clinical";
        String[] arrayValues2 = values2.split("\\s+");
        print("String Array 2", arrayValues2);
    }

    private static void print(String header, String[] strArray){
        System.out.println("====== " + header + " =====");
        for(int i = 0; i < strArray.length; i++){
            System.out.println(strArray[i]);
        }
        System.out.println();
    }
}
