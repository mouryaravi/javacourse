import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.*;

public class MemoryTest {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello World!");
    long current = System.currentTimeMillis();
    System.out.println("Names from memory: " + namesFromMemory());
    System.out.println("Names from memory took: " + (System.currentTimeMillis() - current) + " ms");
    current = System.currentTimeMillis();
    System.out.println("Names from disk: " + namesFromDisk());
    System.out.println("Names from disk took: " + (System.currentTimeMillis() - current) + " ms");
  }
  
  public static String namesFromMemory() throws Exception {
    List<String> names = new ArrayList<String>();
    names.add("Alice");
    names.add("Bob");
    return names.toString();
  }
  
  public static String namesFromDisk() throws Exception {
    Path path = FileSystems.getDefault().getPath("names.txt");
    List<String> names = Files.readAllLines(path, StandardCharsets.UTF_8);
    return names.toString();
  }
}