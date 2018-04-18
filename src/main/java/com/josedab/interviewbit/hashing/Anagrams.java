package com.josedab.interviewbit.hashing;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        int index = 1;
        for (String cad : a) {
            String key = sort(cad);
            if (map.containsKey(key)) {
                map.get(key).add(index);
            } else {
                ArrayList<Integer> r = new ArrayList<Integer>();
                r.add(index);
                map.put(key, r);
            }
            index++;
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public String sort(String cad) {
        char[] chars = cad.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Second timing
    public ArrayList<ArrayList<Integer>> anagramsV2Duplicated(final List<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int index = 1;
        for (String str : A) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(index);
            } else {
                ArrayList<Integer> individualResult = new ArrayList<Integer>();
                individualResult.add(index);
                map.put(key, individualResult);
                result.add(individualResult);
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> test = new LinkedList<String>(Arrays.asList("cat", "dog", "god", "tca"));


        Anagrams solution = new Anagrams();

        ArrayList<ArrayList<Integer>> result = solution.anagrams(test);
        System.out.println(result);
    }

}
