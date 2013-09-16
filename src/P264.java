import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P264 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // generate both lists.
    int[] rows = new int[3200];
    int[] cols = new int[3200];
    int n = 1;
    int n2 = 1;
    int i = 1;
    int j = 1;
    boolean sum1 = false;

    while (n < 10000000) {
      rows[i++] = n;
      cols[j++] = n2;
      if (sum1) {
        n += 1;
        n2 += 4 * (i - 2) + 1;
      } else {
        n += 4 * (i - 2) + 2; // offset is 2, i - 1 is 4 mult
        n2 += 1;
      }
      sum1 = !sum1;
    }

    n = 0;
    do {

    } while (reader.ready());
  }

}
