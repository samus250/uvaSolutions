import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solves UVa problem 10055 "Hashmat the brave warrior".
 * 
 * @author samus250
 */
public class P10055 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    do {
      String line = reader.readLine();
      String[] splitLine = line.split(" ");
      long a = Long.parseLong(splitLine[0]);
      long b = Long.parseLong(splitLine[1]);
      long result = a - b;

      // Do not assume that the input is in order. Make all results
      // non-negative.
      if (result < 0) {
        result = -result;
      }

      System.out.println(result);
    } while (reader.ready());
  }
}
