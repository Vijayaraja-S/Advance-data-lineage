package org.p3.advancedatalineage.model.metadata_beans;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FunctionInfos {
  private String id;
  private String functionName;
  private String functionType;
  private String functionDisplayName;
}
