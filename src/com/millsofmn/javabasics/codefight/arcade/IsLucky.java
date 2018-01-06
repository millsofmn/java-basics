package com.millsofmn.javabasics.codefight.arcade;

public class IsLucky {
    public static void main(String[] args) {
        boolean result = isLucky(1340080);
        System.out.println(result);
    }

    public static boolean isLucky(int n) {
        String number = String.valueOf(n);
        int length = number.length();

        int first = 0;
        int second = 0;
        for(int i = 0; i < length; i++){
            if(i < length/2){
                first += Character.getNumericValue(number.charAt(i));
            } else {
                second += Character.getNumericValue(number.charAt(i));
            }
        }
        return first == second;
    }
}
