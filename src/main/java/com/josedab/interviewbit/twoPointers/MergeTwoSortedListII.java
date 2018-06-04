package com.josedab.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 TIP: C users, please malloc the result into a new array and return the result.
 If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after
 your code is executed should be m + n

 Example :

 Input :
 A : [1 5 8]
 B : [6 9]

 Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedListII {

    public void merge(List<Integer> listA, List<Integer> listB) {
        int aIndex = 0;
        int bIndex = 0;

        //When we inserted all the items from 'b' into 'a' there is no need
        //to continue iteration
        while (bIndex < listB.size()) {
            //Find an element in 'a' which is greater than the current
            //element in 'b'
            while (aIndex < listA.size() && listA.get(aIndex) <= listB.get(bIndex)) {
                aIndex++;
            }
            //Insert the element in 'b' before the element we found
            listA.add(aIndex, listB.get(bIndex));
            //Move to the next element in b
            bIndex++;
        }
    }

    // This is a more complicated solution
    // Better stick to first option
    public void mergeAlternative(List<Integer> listA, List<Integer> listB) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < listA.size() && j < listB.size()) {
            int elemA = listA.get(i);
            int elemB = listB.get(j);
            if (elemA > elemB) {
                result.add(elemB);
                j++;
            } else {
                result.add(elemA);
                i++;
            }
        }
        if (i == listA.size()) {
            while (j < listB.size()) {
                result.add(listB.get(j));
                j++;
            }
        }
        if (j == listB.size()) {
            while (i < listA.size()) {
                result.add(listA.get(i));
                i++;
            }
        }
        listA.clear();
        listA.addAll(result);
    }

    public static void main(String[] args) {
        MergeTwoSortedListII solution = new MergeTwoSortedListII();
        List<Integer> listA = new ArrayList<>(Arrays.asList(1, 5, 8));
        List<Integer> listB = new ArrayList<>(Arrays.asList(6, 9));
        System.out.println(listA);
        solution.merge(listA, listB);
        System.out.println(listA);
    }
}
