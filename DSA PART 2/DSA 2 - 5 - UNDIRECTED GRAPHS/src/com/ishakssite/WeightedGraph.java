package com.ishakssite;

import java.util.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class WeightedGraph {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label)); // "A", Node("A")
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public Path getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        // first, we wanna set the distance to all nodes (directly/indirectly) except the starting node to max integer!
        Map<Node, Integer> distances = new HashMap<>(); // distance to all node from the starting node <the other nodes asides main node, Integer>!
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0); // distance of starting node is 0

        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(fromNode, 0)); // fromNode is starting node!

        while(!queue.isEmpty()) {
            // breadth first traversal
            var current = queue.remove().node;
            visited.add(current);

            // now look at all the neighbors of that node
            for (var edge : current.getEdges()) {
                // if you have visited the target of this edge, then just move on!
                if (visited.contains(edge.to)) continue;

                var newDistance = distances.get(current) + edge.weight; // distance to current node from starting node!
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current); // edge.to is the neighbor
                    queue.add(new NodeEntry(edge.to, newDistance)); // if distance is shorter, this entry is gonna be moved to the front of the priority queue!
                }
            }
        }
        return buildPath(previousNodes, toNode);
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while(previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while(!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values()) {
            if (!visited.contains(node) && hasCycle(node, null, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);

        for (var edge : node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
                return true;
        }

        return false;
    }

    public WeightedGraph getMinimumSpanningTree() {
        var tree = new WeightedGraph();

        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        var startNode = nodes.values().iterator().next(); // iterator() returns 1 item!
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if (edges.isEmpty())
            return tree;

        while (tree.nodes.size() < nodes.size()) { // as long as our tree doesn't contain all the nodes of graph,
            var minEdge = edges.remove(); // in every iteration, we're gonna pick the edge with minimum weight from the queue,
            var nextNode = minEdge.to;

            if (tree.containsNode(nextNode.label)) // then we check if this edge is connected to node that currently exists in our tree,
                continue;

            // if no we're gonna add this edge and target node to our tree >>>
            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label,
                    nextNode.label, minEdge.weight);

            for (var edge : nextNode.getEdges()) // and then we're gonna add all the edges connected to target node to our priority queue, but we're only interested in edges that connect us to a node that we haven't visited so far
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }
}
