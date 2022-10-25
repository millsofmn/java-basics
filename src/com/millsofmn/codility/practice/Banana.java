package com.millsofmn.codility.practice;

// Remove BANANA
public class Banana {
    public static void main(String[] args) {
        System.out.println("1 > " + new Banana().solution("NAABXXAN"));
        System.out.println("2 > " + new Banana().solution("NAANAAXNABABYNNBZ"));
        System.out.println("0 > " + new Banana().solution("QABAAAWOBL"));
    }

    /**
     * #1 100% 16% Performance
     */
    public int solution(String S){
        int times = 0;
        boolean replaced = true;

        while(replaced == true) {

            for (char x : "BANANA".toCharArray()) {
                if (S.contains(String.valueOf(x))) {
                    S = S.replaceFirst(String.valueOf(x), "");
                } else {
                    replaced = false;
                    break;
                }
            }
            if(replaced){
                times++;
            }
        }

        return times;
    }
}
