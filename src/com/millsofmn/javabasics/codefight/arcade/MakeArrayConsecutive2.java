package com.millsofmn.javabasics.codefight.arcade;

import java.util.Arrays;

public class MakeArrayConsecutive2 {
    public static void main(String[] args){
        int result = makeArrayConsecutive2(new int[]{6, 2, 3, 8});
        System.out.println(result);
    }

    static int makeArrayConsecutive2(int[] statues) {
        Arrays.sort(statues);
        int count = 0;
        int last = statues[0];

        for(int i = 1; i < statues.length; i++){
            while(last < statues[i]){
                last++;
                if(last < statues[i]){
                    count++;
                }
            };
            last = statues[i];
        }

        return count;
    }
}
