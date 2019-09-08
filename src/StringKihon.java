import static org.junit.jupiter.api.Assertions.assertEquals;

import framework.StringKihonBase;

public class StringKihon extends StringKihonBase {

    @Override
    protected String Convert_To_Uppercase(String data) {

        return null;
    }

    @Override
    protected String Convert_To_Lowercase(String data) {

        return data.toLowerCase();
    }

    @Override
    protected String Combine_Parts_Of_A_Name(String firstName, String middleName, String lastName) {

        return firstName + " " + middleName + " " + lastName;
    }

    @Override
    protected String Combine_Two_Strings(String a, String b) {

        return a + b;
    }

    @Override
    protected int Determine_The_Length_Of_A_String(String data) {

        return data.length();
    }

    @Override
    protected String Remove_All_Leading_Whitespace(String data) {

        return data.trim();
    }

    @Override
    protected String Remove_All_Trailing_Whitespace(String data) {

        return data.trim();
    }

    @Override
    protected String[] Split_A_String_Into_An_Array(String input, char divider) {

        return input.split(new String(new char[] { divider }));
    }

    @Override
    protected String Join_An_Array_Into_A_String(String[] input, String divider) {
        return String.join(divider,input);
    }

    @Override
    protected boolean Return_True_If_a_Contains_b(String a, String b) {
        return a.contains(b);
    }

    @Override
    protected int Determine_The_Position_Of_a_In_b(String a, String b) {
        return b.indexOf(a);
    }

    @Override
    protected boolean Return_True_If_a_Starts_With_b(String a, String b) {
        return a.startsWith(b);
    }

    @Override
    protected boolean Return_True_Is_a_Ends_With_b(String a, String b) {
        return a.endsWith(b);
    }

    @Override
    protected String Return_The_Fourth_Through_Seventh_Characters_Of_Input(String input) {
        return input.substring(4,7);
    }
}