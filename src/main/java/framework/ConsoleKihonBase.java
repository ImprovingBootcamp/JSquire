package framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ConsoleKihonBase {

    private String input = "This is a test of your code!!" + System.lineSeparator();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    protected abstract void writeFooBarToTheConsole();
    protected abstract void writeLineFooBarToTheConsole();
    protected abstract String readLineFromConsoleAndReturnValue();

    @BeforeEach
    public void beforeEachTest()
    {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @AfterEach
    public void afterEachTest() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void writeFooBarToTheConsoleTest()
    {
        // Arrange


        // Act
        writeFooBarToTheConsole();

        // Assert
        assertEquals("FooBar", outContent.toString());
    }

    @Test
    public void writeLineFooBarToTheConsoleTest()
    {
        // Arrange


        // Act
        writeLineFooBarToTheConsole();

        // Assert
        assertEquals("FooBar\r\n", outContent.toString());
    }

    @Test
    public void readLineFromConsoleAndReturnValueTest() {
        // Arrange

        // Act
        String actual = readLineFromConsoleAndReturnValue();

        // Assert
        assertEquals("This is a test of your code!!", actual);
    }

}
