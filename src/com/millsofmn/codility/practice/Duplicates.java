package com.millsofmn.codility.practice;

import java.util.ArrayList;

public class Duplicates {

    public static void main(String[] args) {
        System.out.println("1 > " + new Duplicates().solution("acbcbba"));
        System.out.println("2 > " + new Duplicates().solution("axxaxa"));
        System.out.println("0 > " + new Duplicates().solution("aaaa"));
    }

    public int solution(String S){
        ArrayList<Character> characters = new ArrayList<>();

        for(char c : S.toCharArray()){
            if(characters.contains(c)){
                characters.remove(characters.indexOf(c));
            } else {
                characters.add(c);
            }
        }

        return characters.size();
    }
}
