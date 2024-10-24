package org.p3.advancedatalineage.model.response;

import lombok.*;
import lombok.Data;

import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Server{
    public String name;
    public String dbVendor;
    public boolean supportsCatalogs;
    public boolean supportsSchemas;
    public List<Database> databases;
}
