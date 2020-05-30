

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Julius..
 */
public class Web_Server {

    
    public static void main(String[] args) throws IOException {
        
        // Server | Sending the first request
        ServerSocket sc = new ServerSocket(9001);
        Socket socket = sc.accept();
        InputStream is = socket.getInputStream();
        Reader r = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(r);
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        socket.close();
        sc.close();
    }
    
}

