package com.millsofmn.javabasics.string;

/**
 * Created by m108491 on 6/14/2016.
 */
public class StringBasics {

    public static void main(String[] args){
        concatenation();
        concatenationStringAndInt();
        compare();
    }

    private static void concatenation() {
        String expletive = "Expletive";
        String pg13 = "deleted";
        String message = expletive + pg13;

        System.out.println(message);
    }

    private static void concatenationStringAndInt(){
        int total = 13;
        String baskets = "Baskets";
        String totalBaskets = baskets + " " + total;

        System.out.println(totalBaskets);
    }

    private static void compare(){
        System.out.println("\nString Compares --------------------------------");
        String str1 = "String";
        String str2 = "String";
        String str3 = "String2";
        String strCapital = "STRING";

        System.out.println("Values");
        System.out.println("str1=" + str1);
        System.out.println("str2=" + str2);
        System.out.println("strCapital=" + strCapital);

        System.out.println("\nString Equals");
        System.out.println("str1.equals(str1): " + str1.equals(str1));
        System.out.println("str1.equals(str1Capital): " + str1.equals(strCapital));
        System.out.println("string.equalsIgnoreCase(stringCapital): " + str1.equalsIgnoreCase(strCapital));

        System.out.println("\nString ==");
        boolean compareSameStr = str1 == str1;
        System.out.println("str1 == str1: " + compareSameStr );
        boolean compareSameValues = str1 == str2;
        System.out.println("str1 == str2: " + compareSameValues);
        boolean compareDiffValues = str1 == str3;
        System.out.println("str1 == str3: " + compareDiffValues);


    }


}
