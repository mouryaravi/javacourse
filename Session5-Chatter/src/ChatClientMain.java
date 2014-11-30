/**
 * Created by ravi on 11/24/14.
 */
public class ChatClientMain {
  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("Usage: ChatClientMain <server host> <server port>");
      System.exit(-1);
    }
    String host = parseHost(args);
    Integer port = parsePort(args);
    new ChatClient(host, port).start();
  }

  private static String parseHost(String[] args) {
    return args[0];
  }

  private static Integer parsePort(String[] args) {
    try {
      return Integer.parseInt(args[1]);
    }
    catch (Exception e) {
      System.out.println("Invalid port: " + args[1]);
      System.exit(-1);
    }
    return null;
  }


}
