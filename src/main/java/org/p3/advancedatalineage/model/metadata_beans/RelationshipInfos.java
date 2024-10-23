package org.p3.advancedatalineage.model.metadata_beans;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RelationshipInfos {
  private String id;
  @Builder.Default private List<SourceInfos> sourceInfosList = new ArrayList<>();
  @Builder.Default private List<TargetInfos> targetInfosList = new ArrayList<>();
}
