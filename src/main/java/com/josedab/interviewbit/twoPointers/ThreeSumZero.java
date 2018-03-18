package com.josedab.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSumZero(List<Integer> ar) {
        int n = ar.size();
        Collections.sort(ar);
        ArrayList<ArrayList<Integer>> lis = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> h = new HashSet<ArrayList<Integer>>();
        for(int i=0;i<n-2;i++){
            int start = i+1, end = n-1;
            while(start<end){
                int total = ar.get(i) + ar.get(start) + ar.get(end);
                if(total>0){
                    end--;
                }
                else if(total<0){
                    start++;
                }
                else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(ar.get(i));
                    temp.add(ar.get(start));
                    temp.add(ar.get(end));
                    if(!h.contains(temp)){
                        h.add(temp);
                        lis.add(temp);
                    }
                    end--;
                    start++;
                }
            }
        }
        return lis;
    }

    public static void main(String[] args) {
        ThreeSumZero solution = new ThreeSumZero();
        System.out.println(
                solution.threeSumZero(
                        Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3)));
    }
}
