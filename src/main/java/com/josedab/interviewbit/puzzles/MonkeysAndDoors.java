package com.josedab.interviewbit.puzzles;

/**
 * There are 100 doors, all closed.
 In a nearby cage are 100 monkeys.

 The first monkey is let out, and runs along the doors opening every one.
 The second monkey is then let out, and runs along the doors closing the 2nd, 4th, 6th,…  - all the even-numbered doors.
 The third monkey is let out. He attends only to the 3rd, 6th, 9th,… doors (every third door, in other words),
 closing any that is open and opening any that is closed, and so on.
 After all 100 monkeys have done their work in this way, what state are the doors in after the last pass?

 Answer with the number of open doors.
 */
public class MonkeysAndDoors {
    public static void main(String[] args) {

        boolean[] doorsOpened = new boolean[100];
        for (int i = 1; i <= 100; i++) {
            for (int idx = 0; idx < 100; idx++) {
                int num = idx + 1;
                if (num % i == 0) {
                    doorsOpened[idx] = !doorsOpened[idx];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 100; i++) {
            if (doorsOpened[i]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
