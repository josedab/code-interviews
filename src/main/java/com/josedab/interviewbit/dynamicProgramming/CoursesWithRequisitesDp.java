package com.josedab.interviewbit.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  There are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites,
 *  for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish
 all courses. return 1/0 if it is possible/not possible.
 The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].

 Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in
 the following order: 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1],
 then it is not possible for you to finish all the courses.

 Solution: this is not graph based solution. It is kind of a dp solution as it is
 based on the previous state to update itself
 */
public class CoursesWithRequisitesDp {
    public int solve(int numberOfCourses, List<Integer> preReqsForCourse, List<Integer> coursesWithRequisites) {
        boolean[] visited = new boolean[numberOfCourses + 1];
        visited[0] = true;
        Map<Integer, List<Integer>> preReqs = new HashMap<>();
        for (int i = 0; i < coursesWithRequisites.size(); i++) {
            Integer elem = coursesWithRequisites.get(i);
            Integer preReq = preReqsForCourse.get(i);
            List<Integer> reqs = preReqs.get(elem);
            if (reqs == null) {
                reqs = new ArrayList<>();
                preReqs.put(elem, reqs);
            }
            reqs.add(preReq);
        }

        boolean areChangesHappening = true;
        while (areChangesHappening) {
            areChangesHappening = false;
            for (int i = 1; i <= numberOfCourses; i++) {
                if (visited[i] == false && isPossibleToDoCourse(i, preReqs, visited)) {
                    areChangesHappening = true;
                    visited[i] = true;
                }
            }
        }

        // This last part can be avoided if we decrement the nCourses and verify for zero value at the end
        // I think it is not crucial for this part as we have already complexity equal to n.
        // Something to express verbally: readability vs affecting K on the complexity
        boolean result = true;
        for (int i = 1; i <= numberOfCourses; i++) {
            result = result && visited[i];
        }

        return result ? 1 : 0;

    }

    private boolean isPossibleToDoCourse(int n, Map<Integer, List<Integer>> preReqs, boolean[] visited) {
        boolean success = true;
        List<Integer> reqs = preReqs.get(n);
        if (reqs != null) {
            for (Integer req : reqs) {
                if (!visited[req]) {
                    success = false;
                    break;
                }
            }
        }
        return success;
    }

    public static void main(String[] args) {
        CoursesWithRequisitesDp solution = new CoursesWithRequisitesDp();
        System.out.println(solution.solve(3, Arrays.asList(1, 2), Arrays.asList(2, 3)));
        System.out.println(solution.solve(3, Arrays.asList(1, 2), Arrays.asList(2, 1)));
    }

}
