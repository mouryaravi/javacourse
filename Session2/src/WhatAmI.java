/**
 * Created by ravi on 11/09/14.
 */
public class WhatAmI {

  public static void main(String[] args) {
    System.out.println("Enter a number:");
    String input = ConsoleUtils.getInputFromUser();
    int num = Integer.parseInt(input);
    System.out.println(isPrime(num));
  }

  public static boolean isPrime(int a) {
    if (a == 2 || a == 1) {
      return true;
    }
    for (int i=2; i < a; i++) {
      if (a % i == 0) {
        return false;
      }
    }
    return true;
  }

}