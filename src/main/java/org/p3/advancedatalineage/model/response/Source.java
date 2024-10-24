package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Source{
    public String id;
    public String column;
    public String parentId;
    public String parentName;
    public List<Coordinate> coordinates;
    public String clauseType;
}
