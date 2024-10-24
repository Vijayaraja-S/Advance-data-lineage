package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Other {
  public List<Column> columns;
  public List<Coordinate> coordinates;
  public String displayName;
  public String id;
  public String name;
  public String type;
}
