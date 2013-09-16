import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P483 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    do {
      String line = reader.readLine();
      Scanner scanner = new Scanner(line);
      while (scanner.hasNext()) {
        String word = scanner.next();
        String reverse = "";
        // print reverse of word
        for (int i = word.length() - 1; i >= 0; i--) {
          reverse += word.charAt(i);
        }
        if (scanner.hasNext()) {
          reverse += " ";
        }
        System.out.print(reverse);
      }
      System.out.println();
    } while (reader.ready());
  }

}
