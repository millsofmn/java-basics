package com.millsofmn.javabasics.codefight.arcade;

public class AlternatingSums {
    public static void main(String[] args) {
        int[] test1 = new int[] {50, 60, 60, 45, 70};
        int[] result1 = alternatingSums(test1);
        System.out.println("Result: " + result1[0] + " " + result1[1]);

        int[] test2 = new int[] {100, 50};
        int[] result2 = alternatingSums(test2);
        System.out.println("Result: " + result2[0] + " " + result2[1]);
    }

private static int[] alternatingSums(int[] a) {
    int sum1 = 0;
    int sum2 = 0;

    for(int i = 0; i < a.length; i++){
        if(i%2 == 0){
            sum1 += a[i];
        } else {
            sum2 += a[i];
        }
    }

    int[] result = new int[]{sum1, sum2};
    return result;
}

}
