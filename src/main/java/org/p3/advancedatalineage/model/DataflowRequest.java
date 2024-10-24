package org.p3.advancedatalineage.model;

import javax.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataflowRequest {

  @NotEmpty(message = "dbVendor not empt")
  private String dbVendor;

  @NotEmpty(message = "sqlText not empt")
  private String sqlText;

  private boolean indirect = true;
  private boolean showConstantTable = true;
  private boolean simpleShowFunction = true;
  private String showResultSetTypes;
  private boolean ignoreRecordSet = true;

  private boolean showTransform = false;
  private boolean tableLevel = false;
}
