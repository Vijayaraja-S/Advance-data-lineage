package org.p3.advancedatalineage.service;

import io.trino.sql.parser.ParsingOptions;
import io.trino.sql.parser.SqlParser;
import io.trino.sql.tree.Node;
import io.trino.sql.tree.Query;
import io.trino.sql.tree.Statement;
import java.util.InputMismatchException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.p3.advancedatalineage.service.nodes.CommonNode;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvanceDataLineageService {
  private final CommonNodeFactory nodeFactory;

  private final MetaDataCollector metaDataCollector;

  public void generateAdvanceLineageGraph(String sqlQuery) {
    DefaultDirectedGraph<Object, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    SqlParser parser = new SqlParser();
    Statement statement = parser.createStatement(sqlQuery, new ParsingOptions());
    if (statement instanceof Query query) {
      List<Node> children = query.getChildren();
      children.forEach(
          child -> {
            CommonNode node = nodeFactory.createNode(child, metaDataCollector, graph);
            node.accept();
          });
    } else {
      throw new InputMismatchException("Invalid statement object");
    }
  }
}
