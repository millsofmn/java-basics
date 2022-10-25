package com.millsofmn.codility.practice;

import java.util.Arrays;

// There are N guests (numbered from 0 to N-1) in a sanatorium waiting to be assigned a room.  In each room,
// any number of guests can be accommodated. However, not all guests like to have a lot of roommates.
//
// You are given an array A of N integers: the K-th guest wants to be in a room that contains at most A[K] guests,
// including themselves.
//
// Write a function:
//   class Solution { public int solution(int[] A); }
//
// that, given the array A, returns the minimum number of rooms needed to accommodate all guests.
// Examples:
//   1. Given A = [1, 1, 1, 1, 1], your function should return 5. Each guest should be accommodated in their
//      own separate room.
//   2. Given A = [2, 1, 4], your function should return 2. The second guest should be accommodated in one
//      room and the other two guests in another room.
//   3. Given A = [2, 7, 2, 9, 8], your function should return 2. The first and the third guests should be
//      accommodated in one room and the other three guests in another room.
//   4. Given A = [7, 3, 1, 1, 4, 5, 4, 9], your function should return 4. The guests can be accommodated as follows:
//      the first two guests in one room, the third and the fourth guests in two single rooms, and the other guests
//      in another room.
//
// Write an efficient algorithm for the following assumptions:
//   N is an integer within the range [1..100,000].
//   each element of array A is an integer within the range [1..100,000].
public class Sanatorium {
    public static void main(String[] args) {
        System.out.println("5 > " + new Sanatorium().solution(new int[]{1, 1, 1, 1, 1}));
        System.out.println("2 > " + new Sanatorium().solution(new int[]{2, 1, 4}));
        System.out.println("2 > " + new Sanatorium().solution(new int[]{2, 7, 2, 9, 8}));
        System.out.println("4 > " + new Sanatorium().solution(new int[]{7, 3, 1, 1, 4, 5, 4, 9}));
    }

    public int solution(int[] A){
        int totalRooms = 0;
        int roomSize = 0;

        Arrays.sort(A);

        for(int i = 0; i < A.length; i++){
            if(roomSize < A[i] && roomSize > 0){
                roomSize--;

            } else {
                totalRooms++;
                roomSize = A[i]-1;
            }

        }
        return totalRooms;
    }
}
