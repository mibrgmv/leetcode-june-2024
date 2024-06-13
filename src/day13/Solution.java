package day13;

import java.util.Arrays;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int numberOfMoves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i=0; i<seats.length; ++i) {
            numberOfMoves += Math.abs(seats[i] - students[i]);
        }

        return numberOfMoves;
    }
}