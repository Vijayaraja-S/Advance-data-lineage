package org.p3.advancedatalineage.service;

import io.trino.sql.parser.ParsingOptions;
import io.trino.sql.parser.SqlParser;
import io.trino.sql.tree.Node;
import io.trino.sql.tree.Query;
import io.trino.sql.tree.Statement;
import java.util.InputMismatchException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.p3.advancedatalineage.service.nodes.CommonNodeFactory;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNode;
import org.p3.advancedatalineage.service.nodes.interfaces.CommonNodeVisitor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvanceDataLineageService {
    private final CommonNodeFactory nodeFactory;
    private final CommonNodeVisitor  commonNodeVisitor;
    private final MetaDataCollector  metaDataCollector;
    public void generateAdvanceLineageGraph(String sqlQuery) {
        SqlParser parser = new SqlParser();
        Statement statement = parser.createStatement(sqlQuery, new ParsingOptions());
        if (statement instanceof Query query) {
            List<Node> children = query.getChildren();
            children.forEach(child -> {
                CommonNode node = nodeFactory.createNode(child,metaDataCollector);
                node.accept(commonNodeVisitor);
            });
        }else {
      throw new InputMismatchException("Invalid statement object");
        }
    }
}
