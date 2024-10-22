package org.p3.advancedatalineage.service.nodes.interfaces;

import org.p3.advancedatalineage.service.nodes.individual_nodes.ExpressionHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.GroupByHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.RelationHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.SelectHandler;
import org.springframework.stereotype.Component;

@Component
public interface CommonNodeVisitor {
    void visit(SelectHandler selectNode);
    void visit(RelationHandler joinNode);
    void visit(ExpressionHandler expressionNode);
    void visit(GroupByHandler groupBy);
}
