package org.p3.advancedatalineage.model.metadata_beans;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TableInfos {
  @Builder.Default private String id = "";
  private UUID referenceId;
  @Builder.Default private String name = "";
  @Builder.Default private String fullName = "";
  @Builder.Default private String aliasName = "";
  @Builder.Default private String schemaName = "";
  @Builder.Default private List<String> duplicateReference = new LinkedList<>();
  @Builder.Default private boolean isHavingDuplicate = false;
}
