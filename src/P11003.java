import java.util.Scanner;

/**
 * Solves UVa problem 11003 "Boxes".
 * 
 * @author samus250
 */
public class P11003 {
  // Max load given by problem constraints.
  static final int MAX_LOAD = 3000;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    while (n != 0) {
      // Initialize f[][] table.
      // f[i][j] = Max stack height using boxes 0..i such that there is still at least j capacity
      // left. We can use the MAX_LOAD constraint of the problem, this way we don't have to wait
      // for all the input to start constructing the table.
      int[][] f = new int[n][MAX_LOAD + 1];

      int wi = scanner.nextInt(); // Weight of box 0.
      int li = scanner.nextInt(); // Load of box 0.

      // Fill the first row base case.
      for (int j = 0; j <= li; j++) {
        f[0][j] = 1;
      }

      // Fill the rest of the table horizontally.
      for (int i = 1; i < n; i++) {
        wi = scanner.nextInt(); // Weight of box i.
        li = scanner.nextInt(); // Load of box i.

        for (int j = 0; j <= MAX_LOAD; j++) {
          // First of all, we know that at least box i can be added to the table for all j <= load
          // of the box i. We did this for the base case.
          if (j <= li) {
            f[i][j] = 1;
          }

          // There might already be a bigger stack even if we don't add it later.
          f[i][j] = Math.max(f[i][j], f[i - 1][j]);

          // We try to add it, remember that we cannot go over the load of the box when
          // filling up the table. For j > li, the stack size must stay as is.
          // Also add the constraint so that we don't go out of bounds.
          if (j <= li && j + wi <= MAX_LOAD) {
            // f[i][j] as is = don't add it.
            // f[i - 1][j + wi] + 1, add it to the last row
            f[i][j] = Math.max(f[i][j], f[i - 1][j + wi] + 1);
          }
        }
      }
      System.out.println(f[n - 1][0]);
      n = scanner.nextInt();
    }
    scanner.close();
  }
}
