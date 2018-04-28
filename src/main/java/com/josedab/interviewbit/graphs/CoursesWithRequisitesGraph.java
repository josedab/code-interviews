package com.josedab.interviewbit.graphs;

import com.josedab.interviewbit.model.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *  There are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites,
 *  for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish
 all courses. return 1/0 if it is possible/not possible.
 The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].

 Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in
 the following order: 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1],
 then it is not possible for you to finish all the courses.

 Solution: this is a graph based solution.
 For dp solution see @{@link com.josedab.interviewbit.dynamicProgramming.CoursesWithRequisitesDp}
 */
public class CoursesWithRequisitesGraph {

    public int solve(int numberOfCourses, List<Integer> preReqsForCourse, List<Integer> coursesWithRequisites) {
        Graph<Integer> g = new Graph<Integer>(numberOfCourses);
        for (int i = 0; i < preReqsForCourse.size(); i++)
            g.addEdge(preReqsForCourse.get(i) - 1, coursesWithRequisites.get(i) - 1);
        return dfs(g) ? 1 : 0;

    }

    private boolean dfs(Graph<Integer> graph) {

        boolean visited[] = new boolean[graph.getNumberOfVertices()];

        for (int vertice : graph.vertices()) {
            if (!visited[vertice]) {
                Stack<Integer> stack = new Stack<>();
                Set<Integer> hist = new HashSet<>();

                stack.push(vertice);
                hist.add(vertice);
                visited[vertice] = true;

                while (!stack.isEmpty()) {
                    int currentVertice = stack.pop();

                    for (int candidate : graph.adj(currentVertice)) {
                        if (hist.contains(candidate)) {
                            return false;
                        }
                        if (!visited[candidate]) {
                            visited[candidate] = true;
                            stack.push(candidate);
                        }
                    }

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CoursesWithRequisitesGraph solution = new CoursesWithRequisitesGraph();
        System.out.println(solution.solve(3, Arrays.asList(1, 2), Arrays.asList(2, 3)));
        System.out.println(solution.solve(3, Arrays.asList(1, 2), Arrays.asList(2, 1)));
    }

}
