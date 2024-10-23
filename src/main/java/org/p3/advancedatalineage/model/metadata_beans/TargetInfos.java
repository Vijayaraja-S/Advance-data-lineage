package org.p3.advancedatalineage.model.metadata_beans;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TargetInfos {
  private String targetId;
  private String targetName;
  private String targetType;
}
