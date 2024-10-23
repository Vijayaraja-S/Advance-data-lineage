package org.p3.advancedatalineage.service.nodes;

import io.trino.sql.tree.*;
import java.util.InputMismatchException;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.MetaDataCollector;
import org.p3.advancedatalineage.service.nodes.individual_nodes.*;
import org.springframework.stereotype.Component;

@Component
public class CommonNodeFactory {

  public CommonNode createNode(
      Node node,
      MetaDataCollector metaDataCollector,
      DefaultDirectedGraph<Object, DefaultEdge> graph) {
    if (node instanceof Select select) {
      return new SelectHandler(select, metaDataCollector, graph, this);
    } else if (node instanceof Relation relation) {
      if (relation instanceof QueryBody queryBody
          && queryBody instanceof QuerySpecification querySpecification) {
        return new QuerySpecificationHandler(querySpecification, metaDataCollector, graph, this);
      }
      return new RelationHandler(relation, metaDataCollector, graph, this);
    } else if (node instanceof Expression expression) {
      return new ExpressionHandler(expression, metaDataCollector, graph, this);
    } else if (node instanceof GroupBy groupBy) {
      return new GroupByHandler(groupBy, metaDataCollector, graph, this);
    } else if (node instanceof With with) {
      return new WithHandler(with, metaDataCollector, graph, this);
    } else if (node instanceof WithQuery withQuery) {
      return new WithQueryHandler(withQuery, metaDataCollector, graph, this);
    } else if (node instanceof Query query) {
      return new QueryHandler(query, metaDataCollector, graph, this);
    }
    throw new InputMismatchException("Unknown node type: " + node.getClass().getName());
  }
}
