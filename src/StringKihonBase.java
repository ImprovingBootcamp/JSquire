import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class StringKihonBase {
    protected abstract String Convert_To_Uppercase(String data);
    protected abstract String Convert_To_Lowercase(String data);
    protected abstract String Combine_Parts_Of_A_Name(String firstName, String middleName, String lastName);
    protected abstract String Combine_Two_Strings(String a, String b);
    protected abstract int Determine_The_Length_Of_A_String(String data);
    protected abstract String Remove_All_Leading_Whitespace(String data);
    protected abstract String Remove_All_Trailing_Whitespace(String data);
    protected abstract String[] Split_A_String_Into_An_Array(String input, char divider);
    protected abstract String Join_An_Array_Into_A_String(String[] input, String divider);
    protected abstract boolean Return_True_If_a_Contains_b(String a, String b);
    protected abstract int Determine_The_Position_Of_a_In_b(String a, String b);
    protected abstract boolean Return_True_If_a_Starts_With_b(String a, String b);
    protected abstract boolean Return_True_Is_a_Ends_With_b(String a, String b);
    protected abstract String Return_The_Fourth_Through_Seventh_Characters_Of_Input(String input);

    @Test
    void Convert_To_Uppercase() {
        // Arrange
        String data = "this is a Simple sTrInG";

        // Act
        String actual = Convert_To_Uppercase(data);

        // Assert
        assertEquals(data.toUpperCase(), actual);
    }

    @Test
    public void Convert_To_Lowercase()
    {
        // Arrange
        String data = "THIS IS A SHOUTING PERSON!";

        // Act
        String actual = Convert_To_Lowercase(data);

        // Assert
        assertEquals(data.toLowerCase(), actual);
    }
    
    @Test
    public void Determine_The_Position_Of_a_In_b()
    {
        // Arrange
        String a = "summer";
        String b = "Now is the winter of our discontent, made glorious summer by the son of York.";

        // Act
        int actual = Determine_The_Position_Of_a_In_b(a, b);

        // Assert
        assertEquals(b.indexOf(a), actual);
    }

    @Test
    public void Return_True_If_a_Contains_b()
    {
        // Arrange
        String a = "This is a simple xyzzy exam";
        String b = "xyzzy";

        // Act
        boolean actual = Return_True_If_a_Contains_b(a, b);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void Return_True_If_a_Starts_With_b()
    {
        // Arrange
        String a = "Fantastic Legendary Musciain";
        String b = "Fantastic Legen";

        // Act
        boolean actual = Return_True_If_a_Starts_With_b(a, b);

        // Assert
        assertTrue(actual);
    }

        @Test
    public void Return_True_Is_a_Ends_With_b()
    {
        // Arrange
        String a = "This is a test";
        String b = "s a test";

        // Act
        boolean actual = Return_True_Is_a_Ends_With_b(a,b);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void Return_The_Fourth_Through_Seventh_Characters_Of_Input()
    {
        // Arrange
        String input = "1234567890";

        // Act
        String actual = Return_The_Fourth_Through_Seventh_Characters_Of_Input(input);

        // Assert
        assertEquals(input.substring(3,4), actual);
    }
}
