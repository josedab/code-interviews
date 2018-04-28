package com.josedab.interviewbit.graphs;

import java.util.Arrays;
import java.util.List;

/**
 * There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle. Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.

 Constraints
 0 <= x , y , R <= 100
 1 <= N <= 1000
 Center of each circle would lie within the grid

 Input
 Input contains x, y , N , R  and two array of size N containing centers of circles.
 The ith index of first array contains x co-ordinate of the ith circle and ith index of second array contains the y co-ordinate of the ith circle.

 Output
 YES or NO depending on weather it is possible to reach cell  (x,y) or not starting from (0,0).

 Sample Input
 2 3 1 1
 2
 3
 Sample Output
 NO
 */
public class ValidPath {

    private static final String YES = "YES";
    private static final String NO = "NO";

    public String solve(int pointX, int pointY, int nCircles, int radio, List<Integer> xCoordinates, List<Integer> yCoordinates) {
        boolean[][] visited = new boolean[pointX + 1][pointY + 1];

        boolean[][] possible = new boolean[pointX + 1][pointY + 1];

        for (int i = 0; i < possible.length; i++) {
            Arrays.fill(possible[i], true);
        }

        // Calculate feasibility of using a point or not
        // After this calculation, the problem resolves into bfs or dfs
        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible[i].length; j++) {
                for (int k = 0; k < xCoordinates.size(); k++) {
                    int x = xCoordinates.get(k);
                    int y = yCoordinates.get(k);

                    if ((x - i) * (x - i) + (y - j) * (y - j) <= radio * radio) {
                        possible[i][j] = false;
                        break;
                    }
                }
            }
        }

        return path(0, 0, possible, visited) ? YES : NO;
    }

    private boolean path(int x, int y, boolean[][] possible, boolean[][] visited) {
        if (x >= possible.length || x < 0 || y >= possible[0].length || y < 0) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (!possible[x][y]) {
            return false;
        }

        if (x == possible.length - 1 && y == possible[possible.length - 1].length - 1) {
            return true;
        }

        visited[x][y] = true;

        return  path(x + 1, y, possible, visited) ||
                path(x + 1, y + 1, possible, visited) ||
                path(x + 1, y - 1, possible, visited) ||

                path(x, y + 1, possible, visited) ||
                path(x, y - 1, possible, visited) ||

                path(x - 1, y + 1, possible, visited) ||
                path(x - 1, y, possible, visited) ||
                path(x - 1, y - 1, possible, visited);
    }

    public static void main(String[] args) {
        ValidPath solution = new ValidPath();
        List<Integer> xCoordinates = Arrays.asList(2);
        List<Integer> yCoordinates = Arrays.asList(3);
        System.out.println(solution.solve(2, 3, 1, 1, xCoordinates, yCoordinates));
    }
}
