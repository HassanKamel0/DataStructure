package org.leetcode.learning.Graph;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.printGraph();
        graph.addEdge("A","B");
        graph.addVertex("C");
        graph.addEdge("A","C");
        graph.addEdge("B","C");
        graph.printGraph();
        graph.removeVertex("C");
        graph.printGraph();
    }
}