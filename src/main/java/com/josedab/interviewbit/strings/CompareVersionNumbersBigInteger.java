package com.josedab.interviewbit.strings;

import java.math.BigInteger;

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

 Easier to read solution: {@link CompareVersionNumbers}
 */
public class CompareVersionNumbersBigInteger {

    public int compareVersion(String v1, String v2) {
        BigInteger[] versionOne = convertToVersionArray(v1);
        BigInteger[] versionTwo = convertToVersionArray(v2);
        return compare(versionOne, versionTwo);
    }

    private BigInteger[] convertToVersionArray(String version) {
        String[] versionsStr = version.split("\\.");
        BigInteger[] versions = new BigInteger[versionsStr.length];
        for (int i = 0; i < versions.length; i++) {
            versions[i] = new BigInteger(versionsStr[i]);
        }

        return versions;
    }

    private int compare(BigInteger[] versionOne, BigInteger[] versionTwo) {
        int size = Math.min(versionOne.length, versionTwo.length);
        BigInteger difference = BigInteger.ZERO;
        for (int i = 0; i < size; i++) {
            difference = difference.add(versionOne[i].subtract(versionTwo[i]));
            if (!difference.equals(BigInteger.ZERO)) {
                break;
            }
        }

        if (difference.equals(BigInteger.ZERO)) {
            //difference = BigInteger.valueOf(versionOne.length-versionTwo.length);
            if (versionOne.length - versionTwo.length < 0) {
                for (int i = size; i < versionTwo.length; i++) {
                    difference = difference.subtract(versionTwo[i]);
                }
            } else if (versionOne.length - versionTwo.length > 0) {
                for (int i = size; i < versionOne.length; i++) {
                    difference = difference.add(versionOne[i]);
                }
            }
        }

        return difference.compareTo(BigInteger.ZERO);
    }

    public static void main(String[] args) {
        CompareVersionNumbersBigInteger solution = new CompareVersionNumbersBigInteger();
        System.out.println(solution.compareVersion("13.0", "13.0.8"));
        System.out.println(solution.compareVersion("2", "4"));
        System.out.println(solution.compareVersion("2.0", "2"));

    }
}
