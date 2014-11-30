import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ravi on 11/24/14.
 */
public class ChatClient {
  private String host;
  private Integer port = 8080;

  public ChatClient(String host, Integer port) {
    this.host = host;
    this.port = port;
  }

  public void start()  throws Exception {
    Socket socket = new Socket(host, port);
    System.out.println ("Local port: "  + socket.getLocalPort() + ", remote: " + socket.getPort());

    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream());
    while (true) {
      String input = System.console().readLine();
      System.out.println("Sending the data: " + input);
      out.write(input + "\n");
      out.flush();
      String data = in.readLine();
      System.out.println("I have received : " + data);
    }
  }

}
