package org.p3.advancedatalineage.service.nodes.interfaces;

public interface CommonNode {
    void accept(CommonNodeVisitor visitor);
}
