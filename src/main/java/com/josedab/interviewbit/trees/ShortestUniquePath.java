package com.josedab.interviewbit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find shortest unique prefix to represent each word in the list.

 Example:

 Input: [zebra, dog, duck, dove]
 Output: {z, dog, du, dov}
 where we can see that
 zebra = z
 dog = dog
 duck = du
 dove = dov

 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible
 */
public class ShortestUniquePath {
    public ArrayList<String> prefix(List<String> strList) {
        ArrayList<String> result = new ArrayList<String>();
        Trie trie = new Trie();

        for (String str : strList) {
            trie.addString(str);
        }

        for (String str : strList) {
            result.add(trie.getRepresentationForString(str));
        }
        return result;

    }

    class Trie {
        Map<Character, Trie> trieMap;
        Map<Character, Integer> characterFreqs;

        Trie() {
            trieMap = new HashMap<>();
            characterFreqs = new HashMap<>();
        }

        void addString(String str) {
            Map<Character, Trie> pointer = trieMap;
            for (int i = 0; i < str.length(); i++) {
                Character c = str.charAt(i);
                Trie trie = pointer.get(c);
                if (trie == null) {
                    trie = new Trie();
                    pointer.put(c, trie);
                    trie.characterFreqs.put(c, 1);
                } else {
                    trie.characterFreqs.put(c, trie.characterFreqs.get(c) + 1);
                }
                pointer = trie.trieMap;
            }
        }

        String getRepresentationForString(String str) {
            StringBuilder result = new StringBuilder();
            Map<Character, Trie> pointer = this.trieMap;
            for (int i = 0; i < str.length(); i++) {
                Character c = str.charAt(i);
                result.append(c);

                Trie trie = pointer.get(c);
                if (trie.characterFreqs.get(c) == 1) {
                    break;
                } else {
                    pointer = trie.trieMap;
                }
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        ShortestUniquePath solution = new ShortestUniquePath();
        System.out.println(solution.prefix(Arrays.asList("bearcat", "bert")));
    }

}
