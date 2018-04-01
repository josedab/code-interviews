package com.josedab.interviewbit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

 Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems

 Constraints:

 1.   1 <= No.of reviews <= 200
 2.   1 <= No. of words in a review <= 1000
 3.   1 <= Length of an individual review <= 10,000
 4.   1 <= Number of Good Words <= 10,000
 5.   1 <= Length of an individual Good Word <= 4
 6.   All the alphabets are lower case (a - z)
 Input:

 S : A string S containing "Good Words" separated by  "_" character. (See example below)
 R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
 Output:

 A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.

 V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
 In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
 Example:

 Input:
 S = "cool_ice_wifi"
 R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

 Output:
 ans = [2, 0, 1]
 Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
 */
public class HotelReviews {
    public ArrayList<Integer> solve(String A, List<String> B) {
        String[] goodWordsArray = A.split("_");
        Set<String> goodWords = new HashSet<>();
        for (String goodWord : goodWordsArray) {
            goodWords.add(goodWord);
        }

        Map<String, Integer> wordPositions = new HashMap<>();
        int index = 0;
        for (String s : B) {
            wordPositions.put(s, index);
            index++;
        }

        Map<String, List<Integer>> goodnessIndexes = new HashMap<String, List<Integer>>();
        for (String str : B) {
            List<Integer> goodnessIdx = getGoodnessIndexes(str, goodWords);
            goodnessIndexes.put(str, goodnessIdx);
        }

        Collections.sort(B, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                List<Integer> o1Idx = goodnessIndexes.get(o1);
                List<Integer> o2Idx = goodnessIndexes.get(o2);
                int result = o2Idx.size() - o1Idx.size();
                if (result == 0) {
                    for (int i = 0; i < o1Idx.size() && result == 0; i++) {
                        result = o2Idx.get(i) - o1Idx.get(i);
                    }
                    if (result == 0) {
                        result = o2.compareTo((String) o1);
                    }
                }
                return result;
            }
        });

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (String str : B) {
            result.add(wordPositions.get(str));
        }
        return result;
    }

    private List<Integer> getGoodnessIndexes(String str, Set<String> goodWords) {
        String[] wordsArray = str.split("_");
        List<Integer> goodnessIndexes = new LinkedList<>();
        int index = 0;
        for (String word : wordsArray) {
            if (goodWords.contains(word)) {
                goodnessIndexes.add(index);
            }
            index++;
        }
        return goodnessIndexes;
    }

    public static void main(String[] args) {
        HotelReviews solution = new HotelReviews();
        System.out.println(solution.solve("cool_ice_wifi", Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")));
    }
}
