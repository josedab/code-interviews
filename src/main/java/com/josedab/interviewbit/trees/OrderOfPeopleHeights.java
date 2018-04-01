package com.josedab.interviewbit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given the following :

 A positive number N
 Heights : A list of heights of N persons standing in a queue
 Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P
 and standing in front of P
 You need to return list of actual order of persons’s height

 Consider that heights will be unique

 Example

 Input :
 Heights: 5 3 2 6 1 4
 InFronts: 0 1 2 0 3 2
 Output :
 actual order is: 5 3 2 1 6 4
 So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and
 hence Infronts has 0 for him.

 For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

 You can do similar inference for other people in the list.
 */
public class OrderOfPeopleHeights {

    public ArrayList<Integer> order(List<Integer> a, List<Integer> b) {
        int[] positions = new int[a.size()];

        List<Pair> pairs = new ArrayList<>(a.size());
        for (int i = 0; i < a.size(); i++) {
            pairs.add(new Pair(a.get(i), b.get(i)));
        }

        // Sorting of pairs by height
        Collections.sort(pairs, (o1, o2) -> o1.getHeight() - o2.getHeight());

        // Location of people in the queue
        for (Pair pair : pairs) {
            int infrontIndex = pair.getInfront();
            int index = 0;
            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == 0) {
                    if (infrontIndex == index) {
                        positions[i] = pair.getHeight();
                        break;
                    } else {
                        index++;
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int position : positions) {
            result.add(position);
        }
        return result;
    }

    public static void main(String[] args) {
        OrderOfPeopleHeights solution = new OrderOfPeopleHeights();
        System.out.println(solution.order(Arrays.asList(5, 3, 2, 6, 1, 4), Arrays.asList(0, 1, 2, 0, 3, 2)));
    }

    private class Pair {
        private int height;
        private int infront;

        public Pair(int height, int infront) {
            this.height = height;
            this.infront = infront;
        }

        public int getHeight() {
            return this.height;
        }

        public int getInfront() {
            return this.infront;
        }
    }
}
