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

    public static void main(String[] args) {
        List<String> test = new LinkedList<String>(Arrays.asList("cat", "dog", "god", "tca"));


        Anagrams solution = new Anagrams();

        ArrayList<ArrayList<Integer>> result = solution.anagrams(test);
        System.out.println(result);
    }

}
