package org.p3.advancedatalineage.model.response;

import java.util.List;
import lombok.*;
import lombok.Data;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Column{
    public Height height;
    public String id;
    public Label label;
    public Width width;
    public X x;
    public Y y;
    public String name;
    public List<Coordinate> coordinates;
    public String source;
}
