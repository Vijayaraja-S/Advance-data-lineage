package org.p3.advancedatalineage.service;

import lombok.Setter;
import org.p3.advancedatalineage.service.nodes.individual_nodes.ExpressionHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.GroupByHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.RelationHandler;
import org.p3.advancedatalineage.service.nodes.individual_nodes.SelectHandler;
import org.springframework.stereotype.Service;

@Service
public class MetadataExtractorVisitor  {
    
    public void visit(SelectHandler selectNode) {
    }
    
    public void visit(RelationHandler joinNode) {
    }

    
    public void visit(ExpressionHandler expressionNode) {
    }
    
    public void visit(GroupByHandler groupBy) {
    }
}
