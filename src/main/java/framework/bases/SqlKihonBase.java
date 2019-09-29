package framework.bases;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class SqlKihonBase {
    public static final String URL = "jdbc:sqlite::memory:";

    protected abstract String Select_All_Fields_And_Rows_From_Person();

    protected abstract String selectAllFieldsFromPersonJoinedToAddress();

    protected abstract String selectFirstNameFromPersonWhereLastNameEqualsRayburn();

    protected abstract String selectAllFieldsFromPersonLeftOuterJoinedToAddress();

    protected abstract String insertPersonId4NamedMikeJohnsonAge5ToPerson();

    protected abstract String updateAllLastNamesRayburnToJohnsonInPerson();

    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {
            setupDatabase(conn);
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    @Test
    public void actualUpdateAllLastNamesRayburnToJohnsonInPerson() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {

            setupDatabase(conn);
            stmt.execute(updateAllLastNamesRayburnToJohnsonInPerson());
            assertEquals(stmt.getUpdateCount(), 2);

            int count = 0;
            var johnsonRS = stmt.executeQuery("select count(*) as count from Person where LastName = 'Johnson'");
            while (johnsonRS.next()) {
                count = johnsonRS.getInt("count");
            }
            assertEquals(2, count);

            count = 0;
            var rayburnRS = stmt.executeQuery("select count(*) as count from Person where LastName = 'Rayburn'");
            while (rayburnRS.next()) {
                count = rayburnRS.getInt("count");
            }
            assertEquals(0, count);
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    @Test
    public void actualInsertPersonId4NamedMikeJohnsonAge5ToPerson() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {
            int count = 0;
            setupDatabase(conn);
            stmt.execute(insertPersonId4NamedMikeJohnsonAge5ToPerson());
            assertEquals(stmt.getUpdateCount(), 1);
            var rs = stmt.executeQuery("select * from person where firstName = 'Mike' and lastname = 'Johnson' and Age = 5");
            while (rs.next()) {
                count += 1;
            }
            assertEquals(1, count);
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    @Test
    public void actualSelectAllFieldsFromPersonLeftOuterJoinedToAddress() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {
            int count = 0;
            setupDatabase(conn);
            var rs = stmt.executeQuery(selectAllFieldsFromPersonLeftOuterJoinedToAddress());
            while (rs.next()) {
                assertEquals(11, rs.getMetaData().getColumnCount());
                count += 1;
            }
            assertEquals(3, count);
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    @Test
    public void actualSelectFirstNameFromPersonWhereLastNameEqualsRayburn() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {
            int count = 0;
            setupDatabase(conn);
            var rs = stmt.executeQuery(selectFirstNameFromPersonWhereLastNameEqualsRayburn());
            while (rs.next()) {
                assertEquals(1, rs.getMetaData().getColumnCount());
                count += 1;
            }
            assertEquals(2, count);
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    @Test
    public void actualSelectAllFieldsFromPersonJoinedToAddress() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {
            setupDatabase(conn);
            int count = 0;
            var rs = stmt.executeQuery(selectAllFieldsFromPersonJoinedToAddress());
            while (rs.next()) {
                assertEquals(11, rs.getMetaData().getColumnCount());
                count += 1;
            }
            assertEquals(1, count);
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    @Test
    public void actualSelectAllFieldsAndRowsFromPerson() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {
            setupDatabase(conn);
            int count = 0;
            var rs = stmt.executeQuery(Select_All_Fields_And_Rows_From_Person());
            while (rs.next()) {
                assertEquals(4, rs.getMetaData().getColumnCount());
                count += 1;
            }
            assertEquals(3, count);
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    public void sampleTest() {
        try (Connection conn = DriverManager.getConnection(URL);
             var stmt = conn.createStatement()) {
            setupDatabase(conn);
            try (var rs = stmt.executeQuery("select count(*) as count from Person;")) {
                while (rs.next()) {
                    var c = rs.getInt("count");
                    assertEquals(3, c);
                }
            }
            try (var rs2 = stmt.executeQuery("select count(*) as count from Address;")) {
                while (rs2.next()) {
                    var c = rs2.getInt("count");
                    assertEquals(2, c);
                }
            }
        } catch (SQLException e) {
            fail("SQLException was thrown. " + e.toString());
        }
    }

    public void setupDatabase(Connection conn) throws SQLException {
        var stmt = conn.createStatement();
        stmt.execute(createPersonTable());
        stmt.execute(createAddressTable());
        stmt.execute(samplePeople());
        stmt.execute(sampleAddresses());
    }

    public String samplePeople() {
        var sb = new StringBuilder();

        sb.append("INSERT INTO PERSON VALUES (1,'Tim','Rayburn',37),");
        sb.append("(2,'Kate','Rayburn',33),");
        sb.append("(3,'Chris','Jackson',38);");

        return sb.toString();
    }

    public String sampleAddresses() {
        var sb = new StringBuilder();

        sb.append("INSERT INTO ADDRESS VALUES (1,1,'1102 Angel Fire Lane',null,'Arlington','TX','76001'),");
        sb.append("(2,4,'1102 Angel Fire Lane',null,'Arlington','TX','76001');");

        return sb.toString();
    }

    public String createAddressTable() {
        var sb = new StringBuilder();

        sb.append("CREATE TABLE Address");
        sb.append("(");
        sb.append("AddressId int not null PRIMARY KEY, ");
        sb.append("PersonId int,");
        sb.append("Line1 varchar(50),");
        sb.append("Line2 varchar(50),");
        sb.append("City varchar(50),");
        sb.append("State varchar(50),");
        sb.append("Zip varchar(9)");
        sb.append(")");

        return sb.toString();
    }

    public String createPersonTable() {
        var sb = new StringBuilder();

        sb.append("CREATE TABLE Person");
        sb.append("(");
        sb.append("PersonId int not null PRIMARY KEY, ");
        sb.append("FirstName varchar(50),");
        sb.append("LastName varchar(50),");
        sb.append("Age int");
        sb.append(")");

        return sb.toString();
    }
}
