package com.millsofmn.javabasics.codefight.challenge;

public class RobotPath {
    public static void main(String[] args) {
        RobotPath r = new RobotPath();

        int[] expectedResult1 = new int[]{-1, 1};
        String instructions1 = "LLLLUUUUDR";
        int bound1 = 2;
        int[] result1 = r.robotPath(instructions1, bound1);
        System.out.println("Expected [" + expectedResult1[0] + "," + expectedResult1[1] + "] was [" + result1[0] + ", " + result1[1] + "]");

        int[] expectedResult2 = new int[]{0, 0};
        String instructions2 = "LRUDLURDLDUR";
        int bound2 = 1;
        int[] result2 = r.robotPath(instructions2, bound2);
        System.out.println("Expected [" + expectedResult2[0] + "," + expectedResult2[1] + "] was [" + result2[0] + ", " + result2[1] + "]");
    }

//int[] robotPath(String t, int b) {
//    int[] l = new int[]{0,0};
//    for (char a : t.toCharArray()) {
//        if(Math.abs(l[0]) <= b && Math.abs(l[1]) <= b ) {
//            if (a == 'L') l[0]--;
//            else if (a == 'D') l[1]--;
//            else if (a == 'R') l[0]++;
//            else if (a == 'U') l[1]++;
//        }
//    }
//    return l;
//}
    // 302
int[] robotPath(String t, int b) {
    int[] l = new int[]{0,0};
    t.chars().forEach(a -> {
        if (a == 'L' && l[0] > -b) l[0]--;
        else if (a == 'D' && l[1] > -b) l[1]--;
        else if (a == 'R' && l[0] < b) l[0]++;
        else if (a == 'U' && l[1] < b) l[1]++;
    });
    return l;
}

//int[] robotPath(String t, int b) {
//    int[] l = new int[]{0,0};
//    for (int i = 0; i < t.length(); i++) {
//        switch (t.charAt(i)) {
//            case 'L':
//                if(l[0] > -b) l[0]--;
//                break;
//            case 'R':
//                if(l[0] < b) l[0]++;
//                break;
//            case 'U':
//                if(l[1] < b) l[1]++;
//                break;
//            case 'D':
//                if(l[1] > -b) l[1] --;
//                break;
//        }
//    }
//    return l;
//}
}
