package com.millsofmn.codility.practice;

/**
 *
 */
public class ValueOfList {
    public static void main(String[] args) {
        System.out.println("2 => " + new ValueOfList().solutions("abccbd", new int[]{0,1,2,3,4,5}));
        System.out.println("3 => " + new ValueOfList().solutions("aabbcc", new int[]{1,2,1,2,1,2}));
        System.out.println("12 => " + new ValueOfList().solutions("aaaa", new int[]{3,4,5,6}));
        System.out.println("0 => " + new ValueOfList().solutions("ababa", new int[]{10,5,10,5,10}));
    }

    public int solutions(String S, int[]c){
        char[] chars = S.toCharArray();

        char lastChar=chars[0];

        int score = 0;

        for(int i = 1; i < S.length(); i++){
            if(lastChar == chars[i]){
                 if(c[i-1] < c[i]){
                     score += c[i-1];
                 } else {
                     score += c[i];
                 }
            }
            lastChar = chars[i];
        }

        return score;
    }
}
