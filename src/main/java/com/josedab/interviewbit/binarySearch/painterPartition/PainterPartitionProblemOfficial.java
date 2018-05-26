package com.josedab.interviewbit.binarySearch.painterPartition;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}.
 * There are K painters available and you are also given how much time a painter takes to paint 1 unit of board.
 * You have to get this job done as soon as possible under the constraints that any painter
 * will only paint contiguous sections of board.

     2 painters cannot share a board to paint. That is to say, a board
     cannot be painted partially by one painter, and partially by another.
     A painter will only paint contiguous boards. Which means a
     configuration where painter 1 paints board 1 and 3 but not 2 is
     invalid.
     Return the ans % 10000003

     Input :
     K : Number of painters
     T : Time taken by painter to paint 1 unit of board
     L : A List which will represent length of each board

     Output:
     return minimum time to paint all boards % 10000003
     Example

     Input :
     K : 2
     T : 5
     L : [1, 10]
     Output : 50

 Official solution provided by InterviewBit
 Binary search approach

 */
public class PainterPartitionProblemOfficial {

    /*

    Hint 1 : Think binary search for the answer.

    If you had a function bool isPossible which could tell you if its possible to
    paint the boards in time T or less, can you solve the problem ?

    Hint 2:
    If you have already solved the problem corresponding to hint1, you are already halfway there.

    You can do a binary search for the answer :

      start = 0, end = max_time_possible
      mid = (start + end) / 2
      if isPossible(mid):
        end = mid - 1
      else
        start = mid + 1
    Now, lets look into how isPossible would be implemented.
    Keep assigning boards to painter greedily till the time taken < mid. If you run out of painters, isPossible = false.
    else isPossible = true.
    */
    public int paint(int k, int t, List<Integer> list) {

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max += (int) (((long) list.get(i)) % 10000003);
            max = max % 10000003;
        }
        int begin = 0, end = max;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (isPossible(k, mid, list))
                end = mid;
            else
                begin = mid + 1;
        }
        return (int) (((long) end * t) % 10000003);
    }

    private boolean isPossible(int k, int averageTime, List<Integer> c) {
        int painterCount = 1;
        int currentTime = 0;
        for (int i = 0; i < c.size(); i++) {
            currentTime += c.get(i);
            if (currentTime > averageTime) {
                painterCount += 1;
                currentTime = c.get(i);
                if (currentTime > averageTime || painterCount > k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PainterPartitionProblemOfficial solution = new PainterPartitionProblemOfficial();
        System.out.println(solution.paint(2, 5, Arrays.asList(1, 10)));
    }
}
