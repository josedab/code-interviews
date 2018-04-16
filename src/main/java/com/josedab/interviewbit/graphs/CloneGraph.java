package com.josedab.interviewbit.graphs;

import com.josedab.interviewbit.model.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode result = cloneGraphAux(node, map);

        return result;
    }

    public UndirectedGraphNode cloneGraphAux(UndirectedGraphNode node,
                                             Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode result = null;
        if (node != null) {
            if (map.containsKey(node)) {
                return map.get(node);
            } else {
                result = new UndirectedGraphNode(node.label);
                map.put(node, result);
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    result.neighbors.add(cloneGraphAux(neighbor, map));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();
        UndirectedGraphNode problem = new UndirectedGraphNode(5);
        UndirectedGraphNode graphSolution = solution.cloneGraph(problem);
        System.out.println(problem != graphSolution && problem.label == graphSolution.label);
    }
}
