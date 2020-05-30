package Server;

import java.io.BufferedWriter;
import java.io.IOException;

public class write404 {

    public static void write404(BufferedWriter bw) throws IOException {
        bw.write("HTTP/1.1 404 File not found");
        bw.newLine();
        bw.newLine();
    }
}
