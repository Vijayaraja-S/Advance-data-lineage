package org.p3.advancedatalineage.service.nodes.individual_nodes;

import io.trino.sql.tree.Expression;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;

public class ExpressionHandler implements CommonNode {
  private final Expression expression;
  private final MetaDataCollector metaDataCollector;
  private final DefaultDirectedGraph<Object, DefaultEdge> graph;
  private final CommonNodeFactory commonNodeFactory;

  public ExpressionHandler(
      Expression expression,
      MetaDataCollector metaDataCollector,
      DefaultDirectedGraph<Object, DefaultEdge> graph,
      CommonNodeFactory commonNodeFactory) {
    this.expression = expression;
    this.metaDataCollector = metaDataCollector;
    this.graph = graph;
    this.commonNodeFactory = commonNodeFactory;
  }

  @Override
  public void accept() {
    processExpression(expression);
  }

  private void processExpression(Expression expression) {}
}
