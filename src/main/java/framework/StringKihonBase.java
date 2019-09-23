package framework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class StringKihonBase {
    protected abstract String convertToUpperCase(String data);

    protected abstract String convertToLowerCase(String data);

    protected abstract String combinePartsOfAName(String firstName, String middleName, String lastName);

    protected abstract String combineTwoStrings(String a, String b);

    protected abstract int determineTheLengthOfAString(String data);

    protected abstract String removeAllLeadingWhitespace(String data);

    protected abstract String removeAllTrailingWhitespace(String data);

    protected abstract String[] splitAStringIntoAnArray(String input, char divider);

    protected abstract String joinAnArrayIntoAString(String[] input, String divider);

    protected abstract boolean returnTrueIfAContainsB(String a, String b);

    protected abstract int determineThePositionOfAInB(String a, String b);

    protected abstract boolean returnTrueIfAStartsWithB(String a, String b);

    protected abstract boolean returnTrueIsAEndsWithB(String a, String b);

    protected abstract String returnTheFourthThroughSeventhCharactersOfInput(String input);

    @Test
    public void determineTheLengthOfAString() {
        // Arrange
        String data = "This is a really long String with random data in it";

        // Act
        int actual = determineTheLengthOfAString(data);

        // Assert
        assertEquals(data.length(), actual);
    }

    @Test
    public void removeAllLeadingWhitespace() {
        // Arrange
        String data = "         data with whitespace pre-pended";

        // Act
        String actual = removeAllLeadingWhitespace(data);

        // Assert
        assertEquals(data.trim(), actual);
    }

    @Test
    public void removeAllTrailingWhitespace() {
        // Arrange
        String data = "This is a test           ";

        // Act
        String actual = removeAllTrailingWhitespace(data);

        // Assert
        assertEquals(data.trim(), actual);
    }

    @Test
    void convertToUpperCase() {
        // Arrange
        String data = "this is a Simple sTrInG";

        // Act
        String actual = convertToUpperCase(data);

        // Assert
        assertEquals(data.toUpperCase(), actual);
    }

    @Test
    public void convertToLowerCase() {
        // Arrange
        String data = "THIS IS A SHOUTING PERSON!";

        // Act
        String actual = convertToLowerCase(data);

        // Assert
        assertEquals(data.toLowerCase(), actual);
    }

    @Test
    public void combineTwoStrings() {
        // Arrange
        String a = "foo";
        String b = "bar";

        // Act
        String actual = combineTwoStrings(a, b);

        // Assert
        assertEquals(a + b, actual);
    }

    @Test
    public void combinePartsOfAName() {
        // Arrange
        String middleName = "John";
        String firstName = "Timothy";
        String lastName = "Rayburn";

        // Act
        String actual = combinePartsOfAName(firstName, middleName, lastName);

        // Assert
        assertEquals(String.format("%s %s %s", firstName, middleName, lastName), actual);
    }


    @Test
    public void determineThePositionOfAInB() {
        // Arrange
        String a = "summer";
        String b = "Now is the winter of our discontent, made glorious summer by the son of York.";

        // Act
        int actual = determineThePositionOfAInB(a, b);

        // Assert
        assertEquals(b.indexOf(a), actual);
    }

    @Test
    public void returnTrueIfAContainsB() {
        // Arrange
        String a = "This is a simple xyzzy exam";
        String b = "xyzzy";

        // Act
        boolean actual = returnTrueIfAContainsB(a, b);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void returnTrueIfAStartsWithB() {
        // Arrange
        String a = "Fantastic Legendary Musciain";
        String b = "Fantastic Legen";

        // Act
        boolean actual = returnTrueIfAStartsWithB(a, b);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void returnTrueIsAEndsWithB() {
        // Arrange
        String a = "This is a test";
        String b = "s a test";

        // Act
        boolean actual = returnTrueIsAEndsWithB(a, b);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void returnTheFourthThroughSeventhCharactersOfInput() {
        // Arrange
        String input = "1234567890";

        // Act
        String actual = returnTheFourthThroughSeventhCharactersOfInput(input);

        // Assert
        assertEquals(input.substring(4, 7), actual);
    }

    @Test
    public void splitAStringIntoAnArray() {
        // Arrange
        char divider = '|';
        String input = "this|is|a|test";

        // Act
        String[] actual = splitAStringIntoAnArray(input, divider);

        // Assert

        assertArrayEquals(input.split(String.valueOf(divider)), actual);
    }

    @Test
    public void joinAnArrayIntoAString() {
        // Arrange
        String divider = " ";
        String[] input = new String[]{"Timothy", "John", "Rayburn"};

        // Act
        String actual = joinAnArrayIntoAString(input, divider);

        // Assert
        assertEquals(String.join(divider, input), actual);
    }
}
