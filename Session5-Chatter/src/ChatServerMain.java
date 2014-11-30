/**
 * Created by ravi on 11/24/14.
 */
public class ChatServerMain {

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("Usage: ChatServer <port>");
      System.exit(-1);
    }
    Integer port = parsePort(args);
    new ChatServer(port).start();
  }

  private static Integer parsePort(String[] args) {
    try {
      return Integer.parseInt(args[0]);
    }
    catch (Exception e) {
      System.out.println("Invalid port: " + args[0]);
      System.exit(-1);
    }
    return null;
  }

}
