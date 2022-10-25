package com.millsofmn.codility.practice;

/**
 * Remove 1 letter to make the longest alphabetical string possible
 */
public class Alabetical {
    public static void main(String[] args) {
        System.out.println("ab > " + new Alabetical().solution("acb"));
        System.out.println("ho > " + new Alabetical().solution("hot"));
        System.out.println("cdility > " + new Alabetical().solution("codility"));
    }

    /**
     * #2 16% Correct 0% Performance
     */
    public String solution(String S){
        char[] c = S.toCharArray();

        int length = 0;
        int skipIdx = 0;

        int first = 0;
        int sec = 0;

        for(int i = 0; i < c.length; i++){
            int tempLength = 0;

            for(int x = 1; x < c.length-1; x++){

                if(x == i){
                    first = x-1;
                    sec = x+1;
                } else {
                    first = x;
                    sec = x+1;
                }
//                System.out.println(c[first] + " " + c[sec]);

                if(c[first] < c[sec]){
                    tempLength++;

                } else {
                    break;
                }

            }
            if(tempLength > length){
                skipIdx = i;
            }
        }

        return S.substring(0, skipIdx) + S.substring(skipIdx+1);

    }
}
