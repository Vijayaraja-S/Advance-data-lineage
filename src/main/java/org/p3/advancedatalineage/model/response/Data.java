package org.p3.advancedatalineage.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@lombok.Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Data{
    public String mode;
    public Graph graph;
    public SqlFlow sqlflow;
}
