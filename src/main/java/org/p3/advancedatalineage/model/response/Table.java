package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Table{
    public List<Column> columns;
    public Height height;
    public Label label;
    public String id;
    public Width width;
    public X x;
    public Y y;
    public List<Coordinate> coordinates;
    public String displayName;
    public String name;
    public String type;
}
