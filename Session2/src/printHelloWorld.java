/**
 * Created by ravi on 11/09/14.
 */
public class PrintHelloWorld {

  public static void main(String[] args) {
    HelloWorld helloWorld = new HelloWorld();
    helloWorld.hello = "HELLO";
    helloWorld.world = "WORLD";
    helloWorld.print();
  }

  private static class HelloWorld {
    String hello;
    String world;

    public void print() {
      System.out.println(hello.toLowerCase() + " " + world.toLowerCase());
    }

  }

}
