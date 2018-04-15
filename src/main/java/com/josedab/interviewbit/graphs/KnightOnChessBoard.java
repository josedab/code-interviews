package com.josedab.interviewbit.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Knight movement on a chess board

 Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.

 Knight's movements on a chess board
 http://i.imgur.com/lmKL4AU.jpg

 The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

 If yes, then what would be the minimum number of steps for the knight to move to the said point.
 If knight can not move from the source point to the destination point, then return -1

 Input:

 N, M, x1, y1, x2, y2
 where N and M are size of chess board
 x1, y1  coordinates of source point
 x2, y2  coordinates of destination point
 Output:

 return Minimum moves or -1
 Example

 Input : 8 8 1 1 8 8
 Output :  6
 */
public class KnightOnChessBoard {

    public int knight(int n, int m, int x1, int y1, int x2, int y2) {
        boolean[][] visited = new boolean[n + 1][m + 1];
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x1, y1, 0));
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.getX();
            int y = point.getY();
            if (x == x2 && y == y2) {
                return point.getSteps();
            } else {
                int stepsForCandidate = point.getSteps() + 1;
                addCandidateIfFeasible(n, m, x + 2, y + 1, stepsForCandidate, visited, queue);
                addCandidateIfFeasible(n, m, x + 2, y - 1, stepsForCandidate, visited, queue);
                addCandidateIfFeasible(n, m, x - 2, y + 1, stepsForCandidate, visited, queue);
                addCandidateIfFeasible(n, m, x - 2, y - 1, stepsForCandidate, visited, queue);

                addCandidateIfFeasible(n, m, x + 1, y + 2, stepsForCandidate, visited, queue);
                addCandidateIfFeasible(n, m, x + 1, y - 2, stepsForCandidate, visited, queue);
                addCandidateIfFeasible(n, m, x - 1, y + 2, stepsForCandidate, visited, queue);
                addCandidateIfFeasible(n, m, x - 1, y - 2, stepsForCandidate, visited, queue);

            }
        }
        return -1;
    }

    private void addCandidateIfFeasible(int n, int m, int x, int y, int steps,
                                        boolean[][] visited,
                                        Deque<Point> queue) {
        if (isValidPoint(n, m, x, y) && !visited[x][y]) {
            queue.offer(new Point(x, y, steps));
            visited[x][y] = true;
        }
    }

    private class Point {
        int x;
        int y;
        int steps;

        public Point(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }

        public int getY() {
            return this.y;
        }

        public int getX() {
            return this.x;
        }

        public int getSteps() {
            return this.steps;
        }

    }


    public boolean isValidPoint(int n, int m, int x1, int y1) {
        return (x1 <= n && x1 >= 1 && y1 <= m && y1 >= 1);
    }

    public static void main(String[] args) {
        KnightOnChessBoard solution = new KnightOnChessBoard();
        System.out.println(solution.knight(8, 8, 1, 1, 8, 8));
        System.out.println(solution.knight(2, 20, 1, 18, 1, 5));
    }
}
