package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\hello.txt"));
        printWriter.print("hiiiiii!");
        printWriter.close();
    }

}
