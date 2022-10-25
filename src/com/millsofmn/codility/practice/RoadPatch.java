package com.millsofmn.codility.practice;

/**
 * 1. S = ".X..X" = 2 for 0-2, 2-7
 * 2. S = "X.XXXXX.X." = 3 for 0-2, 3-5, 6-8
 * 3. S = "XX.XXX.." = 2 for 0-2, 3-5
 * 4. "XXXX" = 2 for 0-2, 1-3
 */
public class RoadPatch {
    public static void main(String[] args) {
        System.out.println("2 => " + new RoadPatch().solution(".X..X"));
        System.out.println("3 => " + new RoadPatch().solution(new String("X.XXXXX.X.")));
        System.out.println("2 => " + new RoadPatch().solution(new String("XXXX")));
    }

    public int solution(String S){
        int patches = 0;
        char[] road = S.toCharArray();
        for(int i = 0; i < road.length; i++){
            if(road[i] == 'X'){
                patches++;
                i+=2;
            }
        }
        return patches;
    }
}
