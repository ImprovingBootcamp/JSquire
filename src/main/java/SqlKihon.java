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
        throw new UnsupportedOperationException();
    }

    @Override
    protected String selectAllFieldsFromPersonJoinedToAddress() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String selectFirstNameFromPersonWhereLastNameEqualsRayburn() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String selectAllFieldsFromPersonLeftOuterJoinedToAddress() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String insertPersonId4NamedMikeJohnsonAge5ToPerson() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String updateAllLastNamesRayburnToJohnsonInPerson() {
        throw new UnsupportedOperationException();
    }
}
