package framework.bases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void beforeEachTest() {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @AfterEach
    public void afterEachTest() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void writeFooBarToTheConsoleTest() {
        // Arrange

        // Act
        writeFooBarToTheConsole();

        // Assert
        assertEquals("FooBar", outContent.toString());
    }

    @Test
    public void writeLineFooBarToTheConsoleTest() {
        // Arrange

        // Act
        writeLineFooBarToTheConsole();

        // Assert
        String outString = outContent.toString();
        boolean windowsCheck = "FooBar\r\n".equals(outString);
        boolean macCheck = "FooBar\n".equals(outString);
        assertTrue(windowsCheck || macCheck);
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
