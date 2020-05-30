package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Julius
 */
public class Web_Server {

    
    public static void main(String[] args) throws IOException {
        
        // Server | Sending the first request
        ServerSocket sc = new ServerSocket(9001);
        Socket socket = sc.accept();
        InputStream is = socket.getInputStream();
        Reader r = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(r);
        String line;
        do {
            line = br.readLine();
            if(line == null || "".equals(line)) {
                break;
            }
            System.out.println(line);
        } while (true);
        
        OutputStream os = socket.getOutputStream();
        Writer w = new OutputStreamWriter(os, "UTF-8");
        BufferedWriter bw = new BufferedWriter(w);
        bw.write("HTTP/1.1 200 OK");
        bw.newLine();
        bw.write("Content-Type: text/html");
        bw.newLine();
        bw.newLine();
        bw.write("<html>");
        bw.write("<body>");
        bw.write("<h1>Hello World!</h1>");
        bw.write("<body>");
        bw.write("</html>");
        bw.flush();
        
        
        socket.close();
        sc.close();
    }
    
}


