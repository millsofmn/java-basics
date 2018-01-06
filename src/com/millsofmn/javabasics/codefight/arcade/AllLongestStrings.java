package com.millsofmn.javabasics.codefight.arcade;

import java.util.ArrayList;
import java.util.List;

public class AllLongestStrings {
    public static void main(String[] args) {
        String[] test1 = new String[]{"aba","aa","ad","vcd","aba"};
        String[] results1 = allLongestStrings(test1);

        for(String s : results1){
            System.out.print(s + ", ");
        }
    }

    public static String[] allLongestStrings(String[] inputArray) {

        int longest = 0;
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i].length() > longest){
                longest = inputArray[i].length();
            }
        }
        List<String> longestStrings = new ArrayList<String>();
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i].length() == longest){
                longestStrings.add(inputArray[i]);
            }
        }

        return longestStrings.toArray(new String[0]);
    }
}
