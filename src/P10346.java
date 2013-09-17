import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Solves UVa problem 10346 "Peter's Smokes".
 * 
 * @author samus250
 */
public class P10346 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    do {
      String line = reader.readLine();
      Scanner scanner = new Scanner(line);
      long n = scanner.nextLong();
      long k = scanner.nextLong();
      long answer = 0;
      while (n > 0) {
        long div = n / k; // extra cigs
        if (div > 0) {
          // n changes
          answer += k * div; // add the cigs
          n = n - k * div + div;
        } else {
          answer += n;
          n = 0;
        }
      }
      System.out.println(answer);
    } while (reader.ready());
  }

}
