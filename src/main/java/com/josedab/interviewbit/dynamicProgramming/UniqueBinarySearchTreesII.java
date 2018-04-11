package com.josedab.interviewbit.dynamicProgramming;

/**
 * Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

 Example :

 Given A = 3, there are a total of 5 unique BST’s.


 1         3     3      2      1
  \       /     /      / \      \
   3     2     1      1   3      2
  /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public int numTrees(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= A; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {
                result += dp[j] * dp[i - j - 1];
            }
            dp[i] = result;
        }
        return dp[A];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
        System.out.println(solution.numTrees(3));
    }
}
