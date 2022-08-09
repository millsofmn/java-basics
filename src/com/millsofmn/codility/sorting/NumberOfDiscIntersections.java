package com.millsofmn.codility.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array
 * A of N non-negative integers, specifying the radiuses of the discs, is
 * given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 *
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
 * K-th discs have at least one common point (assuming that the discs contain
 * their borders).
 *
 * The figure below shows discs drawn for N = 6 and A as follows:
 *
 *   A[0] = 1
 *   A[1] = 5
 *   A[2] = 2
 *   A[3] = 1
 *   A[4] = 4
 *   A[5] = 0
 *
 *
 * There are eleven (unordered) pairs of discs that intersect, namely:
 *
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A describing N discs as explained above, returns the
 * number of (unordered) pairs of intersecting discs. The function should
 * return −1 if the number of intersecting pairs exceeds 10,000,000.
 *
 * Given array A shown above, the function should return 11, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 */
public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        System.out.println("11 => " + new NumberOfDiscIntersections().solution(new int[]{1,5,2,1,4,0}));
    }

    /**
     * Udemy Hint... ok it was the solution. My solutions were off by 1-10 count for some reason.
     * https://app.codility.com/demo/results/training7VGTJ3-9D6/
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int len = A.length;
        DiskLog[] diskHistory = new DiskLog[len * 2];

        int j = 0;
        for (int i = 0; i < A.length; i++) {
            // add a start and end entry to disk log
            diskHistory[j++] = new DiskLog(i - (long) A[i], 1);
            diskHistory[j++] = new DiskLog(i + (long) A[i], -1);
        }
        // sort the disk log
        Arrays.sort(diskHistory);

        int intersection = 0;
        int activeIntersection = 0;

        // interate through the disk log
        for (DiskLog log : diskHistory) {
            activeIntersection += log.startEnd;
            // check if there is disk in this location and if so add it
            if (log.startEnd > 0) intersection += activeIntersection - 1;
            if (intersection > 10000000) return -1;
        }
        return intersection;
    }

    class DiskLog implements Comparable<DiskLog>{
        final long x;
        final int startEnd;

        public DiskLog(long x, int startEnd) {
            this.x = x;
            this.startEnd = startEnd;
        }

        @Override
        public int compareTo(DiskLog o) {
            return this.x != o.x ? Long.compare(this.x, o.x) : Integer.compare(o.startEnd, this.startEnd);
        }
    }

    /**
     * 0% - passed the initial test but failed all the others
     *
     * 0, 1 = [-1, 1] {[0,4][0,8]}
     * 1, 5 = [-4, 6] {[-1,1],[0,4],[2,4],[0,8][5,5]}
     * 2, 2 =  [0, 4] {,[2,4][0,8]}
     * 3, 1 =  [2, 4] {}
     * 4, 4 =  [0, 8] {[2,4],[5,5]}
     * 5, 0 =  [5, 5] {}
     *
     * figure out start and end positions
     * sort positions by start position
     * loop diskArray
     *      loop nextDisk
     *          if(curStartPos < nextStartPos && nextStartPos < curEndPos)
     *              count++
     *          advance nextDisk
     *  advance curDisk
     */
    public int solution1(int[] A){
        int count = 0;

        for(int i = 0; i < A.length; i++){
            int size = A[i];
            int startPos = i - size;
            int endPos = i + size;
            System.out.print(startPos + "," + endPos + " => {");
            for(int y = 0; y < A.length; y++){
                if(i != y) {
                    int innerSize = A[y];
                    int inStartPos = y - innerSize;
                    int inEndPos = y + innerSize;

                    if ((startPos < inStartPos && inStartPos < endPos ) ||
                            (startPos<= inStartPos && inStartPos < endPos && innerSize < size)){
                        count++;
                        System.out.print("[" + inStartPos + "," + inEndPos + "]");
                    }
                }
            }
            System.out.println("}");
        }

        return count > 0 ? count : -1;
    }
}
