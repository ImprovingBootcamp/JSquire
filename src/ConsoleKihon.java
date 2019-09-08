import framework.ConsoleKihonBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleKihon extends ConsoleKihonBase {

    @Override
    protected void Write_FooBar_To_The_Console() {
        System.out.print("FooBar");
    }

    @Override
    protected void WriteLine_FooBar_To_The_Console() {
        System.out.println("FooBar");
    }

    @Override
    protected String Read_Line_From_Console_And_Return_Value() {
        return new Scanner(System.in).nextLine();
    }
}
