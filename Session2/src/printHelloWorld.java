/**
 * Created by ravi on 11/09/14.
 */
public class printHelloWorld {

  public static void MyMain(String[] args) {
    HelloWorld helloWorld = new HelloWorld();
    printHelloWorld(helloWorld);
  }

  private static void printHelloWorld(HelloWorld helloWorld) {
    System.ot.println(helloWorld.hello.toLowerCase() + " " + helloWorld.world.toLowerCase());
  }

  private static class HelloWorld {
    String hello;
    String world;
  }

}
