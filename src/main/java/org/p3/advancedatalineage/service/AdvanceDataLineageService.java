package org.p3.advancedatalineage.service;

import io.trino.sql.parser.ParsingOptions;
import io.trino.sql.parser.SqlParser;
import io.trino.sql.tree.Query;
import io.trino.sql.tree.Statement;
import java.util.InputMismatchException;
import org.springframework.stereotype.Service;

@Service
public class AdvanceDataLineageService {

    public void generateAdvanceLineageGraph(String sqlQuery) {
        SqlParser parser = new SqlParser();
        Statement statement = parser.createStatement(sqlQuery, new ParsingOptions());
        if (statement instanceof Query query) {

        }else {
      throw new InputMismatchException("Invalid statement object");
        }
    }
}
