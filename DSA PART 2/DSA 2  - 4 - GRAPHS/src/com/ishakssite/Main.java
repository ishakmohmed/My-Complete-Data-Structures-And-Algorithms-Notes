package com.ishakssite;

public class Main {

    public static void main(String[] args) {
	    var graph = new Graph();
	    graph.addNode("A");
	    graph.addNode("B");
	    graph.addNode("C");
	    graph.addEdge("A", "C");
	    graph.addEdge("A", "B");
	    graph.removeEdge("A", "C");
	    graph.print();
	    graph.traverseDepthFirstRECURSIVE("A");
    }
}
