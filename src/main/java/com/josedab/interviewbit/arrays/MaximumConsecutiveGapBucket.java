package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Example :

 Input : [1, 10, 5]
 Output : 5
 Return 0 if the array contains less than 2 elements.

 You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 You may also assume that the difference will not overflow.


 NOTE: this is the official solution by InterviewBit. Pushed to the code to have it as a
 reference as it is a different approach and might help to have a different mindset when dealing with other problems.

 Critique:
 It is basically creating a bucketing system and for each element determining the bucket.
 This works if you have n buckets for n numbers, meaning you them sorted.
 But, is this really worth it? No way you are going to put something like this in
 production instead of {@link MaximumConsecutiveGap}.
 It just adds more memory and the k constant for the O(n) solution is too high.
 */
public class MaximumConsecutiveGapBucket {

    class Bucket{
        int low;
        int high;
        public Bucket(){
            low = -1;
            high = -1;
        }
    }

    // Solution O(n)
    public int maximumGap(final List<Integer> a) {

        int[] num = new int[a.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = a.get(i);
        }

        if(num == null || num.length < 2){
            return 0;
        }

        int max = num[0];
        int min = num[0];
        for(int i=1; i<num.length; i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }

        // initialize an array of buckets
        Bucket[] buckets = new Bucket[num.length+1]; //project to (0 - n)
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new Bucket();
        }

        double interval = (double) num.length / (max - min);
        //distribute every number to a bucket array
        for(int i=0; i<num.length; i++){
            int index = (int) ((num[i] - min) * interval);

            if(buckets[index].low == -1){
                buckets[index].low = num[i];
                buckets[index].high = num[i];
            }else{
                buckets[index].low = Math.min(buckets[index].low, num[i]);
                buckets[index].high = Math.max(buckets[index].high, num[i]);
            }
        }

        //scan buckets to find maximum gap
        int result = 0;
        int prev = buckets[0].high;
        for(int i=1; i<buckets.length; i++){
            if(buckets[i].low != -1){
                result = Math.max(result, buckets[i].low-prev);
                prev = buckets[i].high;
            }

        }

        return result;
    }
    public static void main(String[] args) {
        MaximumConsecutiveGapBucket solution = new MaximumConsecutiveGapBucket();
        System.out.println(solution.maximumGap(Arrays.asList(1, 10, 5)));
    }
}
