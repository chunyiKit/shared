package org.example;

import org.apache.calcite.avatica.util.Casing;
import org.apache.calcite.avatica.util.Quoting;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import com.aloudata.demo.parser.impl.DemoSqlParserImpl;

public class Main {
    public static void main(String[] args) throws SqlParseException {
        String sql = "CREATE MATERIALIZED VIEW IF NOT EXISTS \"test\".\"demo\".\"materializationName\" AS SELECT * FROM \"system\"";

        SqlParser.Config myConfig = SqlParser.config()
                .withQuoting(Quoting.DOUBLE_QUOTE)
                .withQuotedCasing(Casing.UNCHANGED)
                .withParserFactory(DemoSqlParserImpl.FACTORY);
        SqlParser parser = SqlParser.create(sql, myConfig);
        SqlNode sqlNode = parser.parseQuery();
        System.out.println(sqlNode);
    }
}