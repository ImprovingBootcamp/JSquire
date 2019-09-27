package framework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public abstract class FileOperationsKihonBase {
    public abstract String getContentsOfThisFile(Path pathOfFile) throws IOException;
    public abstract void writeContentsToThisFile(Path pathOfFile, String contents) throws IOException;

    @Test
    public void getContentsOfThisFileTest(@TempDir Path tempDir) throws IOException {
        // Arrange
        final String fileContents = "Hello, is this the banana phone?";
        Path tempFile = tempDir.resolve("temp-file.txt");
        Files.writeString(tempFile, fileContents);

        // Act
        String returnedContents = getContentsOfThisFile(tempFile);

        // Assert
        assertEquals(fileContents, returnedContents);

    }

    @Test
    public void writeContentsToThisFileTest(@TempDir Path tempDir) throws IOException {
        // Arrange
        final String fileContents = "No, this is Patrick.";
        Path tempFile = tempDir.resolve("temp-file.txt");

        // Act
        writeContentsToThisFile(tempFile, fileContents);

        // Assert
        assertEquals(fileContents, Files.readString(tempFile));

    }

}
