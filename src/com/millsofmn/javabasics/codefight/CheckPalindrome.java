package com.millsofmn.javabasics.codefight;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {

    public static void main(String[] args){

        Map<String, Boolean> testStrings = new HashMap<String, Boolean>();
        testStrings.put("a", true);
        testStrings.put("racecar", true);
        testStrings.put("lyle", false);
        testStrings.put("dsllsd", true);
        testStrings.put("dsllsdd", false);
        testStrings.put("aabaa", true);

        for(String key : testStrings.keySet()){
            if(checkPalindrome(key) == testStrings.get(key)){
                System.out.println(key + " is identified correctly");
            } else {
                System.out.println(key + " is identified as an error");
            }
        }
    }

    static boolean checkPalindrome(String inputString){

        char[] charArray = inputString.toCharArray();

        int i = 0;
        int y = inputString.length() - 1;
        while(i < y){
            if(charArray[i] == charArray[y]){
                y--;
                i++;
            } else {
                return false;
            }
        }

        return true;
    }
}
