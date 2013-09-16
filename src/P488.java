import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solves UVa problem 488 "Triangle Waves".
 * 
 * @author samus250
 */
public class P488 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    // Hardcoded amplitude values for quick access.
    String[] amplitudes = { "1", "22", "333", "4444", "55555", "666666", "7777777", "88888888",
        "999999999" };

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int cases = Integer.parseInt(reader.readLine());

    for (int i = 0; i < cases; i++) {
      String wave = "";
      reader.readLine();
      int amplitude = Integer.parseInt(reader.readLine());
      int frequency = Integer.parseInt(reader.readLine());

      // First half of wave, go from 1 to amplitude.
      for (int j = 0; j < amplitude; j++) {
        wave += amplitudes[j] + "\n";
      }

      // Second half, go from amplitude - 1 to 1.
      for (int j = amplitude - 2; j >= 0; j--) {
        wave += amplitudes[j] + "\n";
      }

      for (int k = 0; k < frequency; k++) {
        System.out.print(wave);

        // Don't print newline for last wave.
        if (k != frequency - 1) {
          System.out.println();
        }
      }

      // Don't print extra newline for last case.
      if (i != cases - 1) {
        System.out.println();
      }
    }
  }
}
