package framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class ConsoleKihonBase {

    private String input = "This is a test of your code!!" + System.lineSeparator();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    protected abstract void Write_FooBar_To_The_Console();
    protected abstract void WriteLine_FooBar_To_The_Console();
    protected abstract String Read_Line_From_Console_And_Return_Value() throws IOException;

    @BeforeEach
    public void BeforeEachTest()
    {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @AfterEach
    public void AfterEachTest() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void Write_FooBar_To_The_Console_Test()
    {
        // Arrange


        // Act
        Write_FooBar_To_The_Console();

        // Assert
        assertEquals("FooBar", outContent.toString());
    }

    @Test
    public void WriteLine_FooBar_To_The_Console_Test()
    {
        // Arrange


        // Act
        WriteLine_FooBar_To_The_Console();

        // Assert
        assertEquals("FooBar\r\n", outContent.toString());
    }

    @Test
    public void Read_Line_From_Console_And_Return_Value_Test() throws IOException {
        // Arrange

        // Act
        var actual = Read_Line_From_Console_And_Return_Value();

        // Assert
        assertEquals("This is a test of your code!!", actual);
    }

}
