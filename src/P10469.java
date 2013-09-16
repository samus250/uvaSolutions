import java.io.IOException;
import java.util.Scanner;

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
  }
}
