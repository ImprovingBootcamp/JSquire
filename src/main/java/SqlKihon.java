import framework.SqlKihonBase;

public class SqlKihon extends SqlKihonBase {

    /* Given SQL Tables defined as:
     * ----------------------------
     * CREATE TABLE Person
       (
         PersonId int not null PRIMARY KEY,
         FirstName varchar(50),
         LastName varchar(50),
         Age int
       )
     *
     * CREATE TABLE Address
       (
         AddressId int not null PRIMARY KEY,
         PersonId int,
         Line1 varchar(50),
         Line2 varchar(50),
         City varchar(50),
         State varchar(50),
         Zip varchar(9)
       )
     */

    @Override
    protected String Select_All_Fields_And_Rows_From_Person() {
        return "select * from person";
    }

    @Override
    protected String selectAllFieldsFromPersonJoinedToAddress() {
        return "select * from person p join address a on p.personid = a.personid";
    }

    @Override
    protected String selectFirstNameFromPersonWhereLastNameEqualsRayburn() {
        return "select firstname from person where lastname = 'Rayburn'";
    }

    @Override
    protected String selectAllFieldsFromPersonLeftOuterJoinedToAddress() {
        return "select * from person p left outer join address a on p.personid = a.personid";
    }

    @Override
    protected String insertPersonId4NamedMikeJohnsonAge5ToPerson() {
        return "insert into person(personid,firstname,lastname,age) values (4,'Mike','Johnson',5)";
    }

    @Override
    protected String updateAllLastNamesRayburnToJohnsonInPerson() {
        return "update person set lastname = 'Johnson' where lastname='Rayburn'";
    }
}
