import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10405 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String line1, line2;
    do {
      line1 = reader.readLine();
      line2 = reader.readLine();

      System.out.println(lcs(line1, line2));
    } while (reader.ready());
  }

  private static int lcs(String line1, String line2) {
    char[] s1 = line1.toCharArray();
    char[] s2 = line2.toCharArray();

    int[][] table = new int[s1.length + 1][s2.length + 1];

    for (int i = 0; i < s1.length; i++) {
      for (int j = 0; j < s2.length; j++) {
        if (s1[i] == s2[j])
          table[i + 1][j + 1] = table[i][j] + 1;
        else
          table[i + 1][j + 1] = Math.max(table[i + 1][j], table[i][j + 1]);
      }
    }

    return table[s1.length][s2.length];
  }
}
