package org.p3.advancedatalineage;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.Set;

public class GraphExample {
  public static void main(String[] args) {
    // Create a directed graph
    DefaultDirectedGraph<Object, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

    // Add vertices
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addVertex("E");
    graph.addVertex("F");
    graph.addVertex("G");

    // Add edges
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("A", "D");
    graph.addEdge("B", "C");
    graph.addEdge("C", "A");

    // Extract only the nodes (vertices)
    Set<Object> nodes = graph.vertexSet();

    // Print the nodes
    System.out.println("Nodes in the graph: " + nodes);
  }
}
