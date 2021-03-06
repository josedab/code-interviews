package com.josedab.interviewbit.hashing;


import java.util.HashMap;
import java.util.Map;

/**

 Given a string,
 find the length of the longest substring without repeating characters.

 Example:

 The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

 For "bbbbb" the longest substring is "b", with the length of 1.

 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String A) {
        Map<Character, Integer> positions = new HashMap<Character, Integer>();
        int result = 0;
        int[] lastCharacterIndex = new int[A.length()];

        for (int i = 0; i < A.length(); i++) {
            Character c = A.charAt(i);
            if (!positions.containsKey(c)) {
                lastCharacterIndex[i] = -1;
            } else {
                lastCharacterIndex[i] = positions.get(c);
            }
            positions.put(c, i);
        }

        lastCharacterIndex[0] = 1;
        if (A.length() == 1) {
            result = 1;
        }
        for (int i = 1; i < A.length(); i++) {
            int maxLengthForIndex =
                    lastCharacterIndex[i] == -1 ?
                            1 + lastCharacterIndex[i - 1] :
                            Math.min(i - lastCharacterIndex[i], 1 + lastCharacterIndex[i - 1]);
            lastCharacterIndex[i] = maxLengthForIndex;
            result = Math.max(result,
                    maxLengthForIndex);
        }
        return result;
    }

    public int lengthOfLongestSubstringAlternative(String a) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int count = 0;
        int lastIndex = 0;
        for (int i = 0; i < a.length(); i++) {
            Character c = a.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                count++;
                max = Math.max(max, count);
            } else {

                if (map.get(c) >= lastIndex) {

                    max = Math.max(max, count);
                    count = i - map.get(c);
                    map.put(c, i);
                    lastIndex = i - count + 1;
                } else {
                    map.put(c, i);
                    count++;
                    max = Math.max(max, count);
                }

            }
        }
        return max;
    }

    /*

     public int lengthOfLongestSubstring(String A) {

        int count = 0;
        int max = 0;
	    int n = A.length();
	    HashMap<Character, Integer> hashMap = new HashMap<>();
	    char c;
	    int prevIndex;

	    for (int i = 0; i < n; i++) {

	        c = A.charAt(i);

	        if (hashMap.containsKey(c)) {
	            prevIndex = hashMap.get(c);
	            count = Math.min(count + 1, i - prevIndex);
	            hashMap.put(c, i);
	        } else {
	            count++;
	            hashMap.put(c, i);
	        }

	        max = Math.max(max, count);
	    }

	    return max;
	}
     */

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String test = "dadbc";
        test = "Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV";
        test = "3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV";
        test = "4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD";
        test = "4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33";
        int result = solution.lengthOfLongestSubstring(test);
        System.out.println(result);
    }
}
