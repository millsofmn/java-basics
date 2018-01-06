package com.millsofmn.javabasics.codefight.arcade;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class CommonCharacterCount {
    public static void main(String[] args) {
        int result = commonCharacterCount("aabcc", "adcaa");
        System.out.println(result);
    }

    public static int commonCharacterCount(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Map<Character, Integer> inv1 = new HashMap<>();
        for(char c : s1.toCharArray()){
            if(inv1.containsKey(c)){
                int count = inv1.get(c);
                inv1.put(c, ++count);
            } else {
                inv1.put(c, 1);
            }
        }

        Map<Character, Integer> inv2 = new HashMap<>();
        for(char c : s2.toCharArray()){
            if(inv2.containsKey(c)){
                int count = inv2.get(c);
                inv2.put(c, ++count);
            } else {
                inv2.put(c, 1);
            }
        }

        int total = 0;
        Map<Character, Integer> common = new HashMap<>();
        for(char key : inv2.keySet()){
            if(inv1.containsKey(key) && inv2.containsKey(key)){
                if(inv1.get(key) > inv2.get(key)){
                    total += inv2.get(key);
                } else {
                    total += inv1.get(key);
                }
            }
        }
        return total;
    }
}
