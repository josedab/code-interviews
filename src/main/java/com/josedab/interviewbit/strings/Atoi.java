package com.josedab.interviewbit.strings;

/**
 * Implement atoi to convert a string to an integer.

 Example :

 Input : "9 2704"
 Output : 9
 Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
 A. Yes Q2. Can the string have garbage characters after the number?
 A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
 A. Return 0. Q4. What if the integer overflows?
 A. Return INT_MAX if the number is positive, INT_MIN otherwise.

 Note: don't use library function such as Integer.valueOf(...) or parseInt
 */
public class Atoi {

    public int atoi(final String strr) {
        long result = 0;
        int sign = 1;
        boolean numberSeqStarted = false;
        String str = strr.trim();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);


            if (!numberSeqStarted && isSign(c)) {
                numberSeqStarted = true;
                sign = (c == '-') ? -1 : 1;
            } else if (!numberSeqStarted && isNumber(c)) {
                numberSeqStarted = true;
            } else if ((numberSeqStarted && !isNumber(c)) || !numberSeqStarted) {
                break;
            }

            if (!isSign(c) && numberSeqStarted) {
                result = result * 10 + sign * (c - '0');

                // Overflow
                if (sign > 0 && result > Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                    break;
                } else if (sign < 0 && result < Integer.MIN_VALUE) {
                    result = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return (int) result;
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        Atoi solution = new Atoi();

        String problem = "+7";
        System.out.println(solution.atoi(problem));

        problem = "5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393";
        System.out.println(solution.atoi(problem));

        problem = "7 U 0 T7165 0128862 089 39 5";
        System.out.println(solution.atoi(problem));
    }
}
