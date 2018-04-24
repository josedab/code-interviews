package com.josedab.interviewbit.strings;

/**
 * Compare two version numbers version1 and version2.

 If version1 > version2 return 1,
 If version1 < version2 return -1,
 otherwise return 0.
 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
 revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

 Alternative with BigIntegers: {@link CompareVersionNumbersBigInteger}
 */
public class CompareVersionNumbers {

    public int compareVersion(String v1, String v2) {

        int[] versionOne = convertToVersionArray(v1);
        int[] versionTwo = convertToVersionArray(v2);
        return compare(versionOne, versionTwo);
    }

    private int[] convertToVersionArray(String version) {
        String[] versionsStr = version.split("\\.");
        int[] versions = new int[versionsStr.length];
        for (int i = 0; i < versions.length; i++) {
            versions[i] = Integer.valueOf(versionsStr[i]);
        }

        return versions;
    }

    private int compare(int[] versionOne, int[] versionTwo) {
        int size = Math.min(versionOne.length, versionTwo.length);
        int difference = 0;
        for (int i = 0; i < size; i++) {
            difference += versionOne[i] - versionTwo[i];
            if (difference != 0) {
                break;
            }
        }

        if (difference == 0) {
            difference = versionOne.length - versionTwo.length;
        }

        if (difference > 0) {
            difference = 1;
        } else if (difference < 0) {
            difference = -1;
        }

        return difference;
    }

    public static void main(String[] args) {
        CompareVersionNumbers solution = new CompareVersionNumbers();
        System.out.println(solution.compareVersion("13.0", "13.0.8"));
        System.out.println(solution.compareVersion("2", "4"));
        System.out.println(solution.compareVersion("2", "2"));

    }
}
