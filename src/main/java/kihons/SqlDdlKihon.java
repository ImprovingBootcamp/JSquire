package kihons;

import framework.bases.SqlDdlKihonBase;

public class SqlDdlKihon extends SqlDdlKihonBase {
    @Override
    public String createTablePersonWithOneColumn() {
        var sb = new StringBuilder();

        sb.append("CREATE TABLE Person");
        sb.append("(");
        sb.append("PersonId int not null PRIMARY KEY ");
        sb.append(")");

        return sb.toString();
    }
}
