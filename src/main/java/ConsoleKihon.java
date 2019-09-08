import framework.ConsoleKihonBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleKihon extends ConsoleKihonBase {

    @Override
    protected void writeFooBarToTheConsole() {
        System.out.print("FooBar");
    }

    @Override
    protected void writeLineFooBarToTheConsole() {
        System.out.println("FooBar");
    }

    @Override
    protected String readLineFromConsoleAndReturnValue() {
        return new Scanner(System.in).nextLine();
    }
}
