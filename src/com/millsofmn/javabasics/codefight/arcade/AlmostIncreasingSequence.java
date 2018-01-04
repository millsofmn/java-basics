package com.millsofmn.javabasics.codefight.arcade;


import java.util.LinkedHashMap;
import java.util.Map;

public class AlmostIncreasingSequence {
    public static void main(String[] args){
        AlmostIncreasingSequence almostIncreasingSequence = new AlmostIncreasingSequence();

        Map<int[], Boolean> tests = new LinkedHashMap<>();
        tests.put(new int[]{1, 2, 3, 4, 5}, true); // happy path
        tests.put(new int[]{100, 99, 98}, false); // three in descending order
        tests.put(new int[]{1, 2, 1, 2}, false); // duplicates
        tests.put(new int[]{1, 2, 5, 3, 5}, true); // skip one
        tests.put(new int[]{10, 1, 2, 3, 4, 5}, true); // skip first
        tests.put(new int[]{1, 2, 3, 1}, true); // skip last
        tests.put(new int[]{1, 2, 5, 5, 5}, false); // skip same
        tests.put(new int[]{1, 2, 3, 4, 5, 3, 5, 6}, false);
        tests.put(new int[]{1, 2, 3, 4, 3, 6}, true);
        tests.put(new int[]{1, 3, 2}, true);
        tests.put(new int[]{1, 2, 3}, true);
        tests.put(new int[]{1, 4, 10, 4, 2}, false);
        tests.put(new int[]{1, 1, 1, 2, 3}, false);
        tests.put(new int[]{0, -2, 5, 6}, true);
        tests.put(new int[]{40, 50, 60, 10, 20, 30}, false);
        tests.put(new int[]{1, 1}, true);
        tests.put(new int[]{10, 1, 2, 3, 4, 5, 6, 1}, false);
        tests.put(new int[]{1, 2, 3, 4, 99, 5, 6}, true);
        tests.put(new int[]{123, -17, -5, 1, 2, 3, 12, 43, 45}, true);
        tests.put(new int[]{3, 5, 67, 98, 3}, true);
        tests.put(new int[]{-3268, -457988, -457987, 8901, 878218901,878218902}, true);

        for(int[] key : tests.keySet()){
            StringBuilder sb = new StringBuilder();
            for(int i : key){
                sb.append(i).append(", ");
            }
            sb.append(" = ");
            if(tests.get(key) == almostIncreasingSequence.almostIncreasingSequence(key)){
                sb.append("correct");
            } else {
                sb.append("wrong");
            }
            System.out.println(sb.toString());
        }
    }

    static boolean almostIncreasingSequence(int[] sequence){

        int skipped = 0;

        // having only 3 are tricky because of order
        if(sequence.length == 3){
            int a = sequence[0];
            int b = sequence[1];
            int c = sequence[2];

            if((a < b && b < c) ||
                    (a < c) || (b < c)) {
                return true;
            } else {
                return false;
            }

        } else {
            // continue while a < b < c
            //   skip b
            //      if a < c and c < d then continue
            //   skip a
            //      if -a < b && b < c then continue
            //   skip c
            //      if a < b && b < d then continue
            //
            for(int x = 0; x < sequence.length - 2; x++){
                // looking at a, b, c keep in step with length it's -2
                int a = sequence[x];
                int b = sequence[x + 1];
                int c = sequence[x + 2];

                if(!(a < b && b < c)){
                    // skip b
                    if(x < sequence.length - 3 && a < c && c < sequence[x + 3]){
                        skipped++;
                        x+=2;

                    // skip a
                    } else if(x > 1 && sequence[x -1] < b && b < c){
                        skipped++;

                    // skip c
                    } else if(x < sequence.length - 3 && a < b && b < sequence[x + 3]){
                        skipped++;
                        x+=4; // advance to skip c

                    // unhandled case so just skip
                    } else {
                        skipped++;
                    }
                }
                if(skipped > 1) return false;
            }
        }

        return true;
    }
}
