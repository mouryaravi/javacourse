import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ravi on 11/24/14.
 */
public class ChatServer {
  private int port = 8080;
  public ChatServer(Integer port) {
    if (port != null) {
      this.port = port;
    }
  }

  public void start() throws Exception {
    ServerSocket socket = new ServerSocket(port);
    System.out.println("Listening for the connections on port: " + port + " ....");
    Socket clientSocket = socket.accept();
    System.out.println ("Local port: "  + clientSocket.getLocalPort() + ", remote: " + clientSocket.getPort());

    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
    System.out.println("Got the connection....");

    while(true) {
      String data = in.readLine();
      System.out.println("I have received : " + data);
      String input = System.console().readLine();
      out.write(input + "\n");
      out.flush();
    }
  }


}
