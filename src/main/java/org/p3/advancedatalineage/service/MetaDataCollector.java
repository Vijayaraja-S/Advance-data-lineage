package org.p3.advancedatalineage.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.p3.advancedatalineage.model.metadata_beans.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MetaDataCollector {

  private final Map<String, List<ColumnInfos>> overAllColumMap = new LinkedHashMap<>();
  private final Map<String, List<TableInfos>> overAllTableMap = new LinkedHashMap<>();
  private final Map<String, List<SchemaInfos>> overAllschemaMap = new LinkedHashMap<>();
  private final Map<String, List<ApplicationInfos>> overAllApplicationMap = new LinkedHashMap<>();
  private final Map<String, List<FunctionInfos>> overAllFunctionsInfoMap = new LinkedHashMap<>();
  private final Map<String, List<RelationshipInfos>> overAllColumnInfoMap = new LinkedHashMap<>();

  private String searchOrMvName;
  private String searchIdOrMaterializedViewId;
}
