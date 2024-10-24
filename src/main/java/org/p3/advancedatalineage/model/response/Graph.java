package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Graph{
    public Elements elements;
    public Tooltip tooltip;
    public Map<String,List<String>> listIdMap;
    public  Map<String,List<String>> relationshipIdMap;
}
