import java.io.IOException;
import java.util.Scanner;

/**
 * Solves UVa problem 10469 "To Carry or not to Carry".
 * 
 * @author samus250
 */
public class P10469 {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(a ^ b);
      } catch (Exception e) {
        break;
      }
    }
    scanner.close();
  }
}
