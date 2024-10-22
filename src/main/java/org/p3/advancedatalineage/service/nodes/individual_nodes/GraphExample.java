package org.p3.advancedatalineage.service.nodes.individual_nodes;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.model.metadata_beans.ColumnInfos;

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

    // Print the graph
    System.out.println(graph);
  }
}
