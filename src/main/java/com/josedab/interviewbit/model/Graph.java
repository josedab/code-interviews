package com.josedab.interviewbit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jbaena on 4/28/18.
 */
public class Graph<T> {
    int V;
    Map<T, List<T>> edges;

    public Graph(int v) {
        V = v;
        this.edges = new HashMap<>(v);
    }

    public void addEdge(T v, T w) {
        if (!edges.containsKey(v)) {
            edges.put(v, new ArrayList<T>());
        }
        edges.get(v).add(w);
    }

    public Iterable<T> vertices() {
        return edges.keySet();
    }

    public Iterable<T> adj(int v) {
        if (!edges.containsKey(v)) {
            return Collections.emptyList();
        }
        return edges.get(v);
    }

    public int getNumberOfVertices(){
        return this.V;
    }
}
