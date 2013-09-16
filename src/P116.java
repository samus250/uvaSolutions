import java.util.Scanner;

public class P116 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int m = scanner.nextInt(); // Rows
      int n = scanner.nextInt(); // Cols

      int[][] matrix = new int[m][n];

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = scanner.nextInt();
        }
      }

      for (int i = n - 1; i > 0; i--) {
        for (int j = 0; j < m; j++) {
          // Find minimum of matrix[i][j-1],[j],[j+1] and add to matrix[i-1][j].
          int index1 = (j - 1 < 0) ? m - 1 : j - 1;
          int index2 = j;
          int index3 = (j + 1 > m - 1) ? 0 : j + 1;
          int n1 = matrix[index1][i];
          int n2 = matrix[index2][i];
          int n3 = matrix[index3][i];
          int min = Math.min(Math.min(n1, n2), n3);
          matrix[j][i - 1] += min;
        }
      }

      // At the end, the minimum of the first column is what we need.
      int min = Integer.MAX_VALUE;
      int minIndex = 0;
      for (int i = 0; i < m; i++) {
        if (min > matrix[i][0]) {
          minIndex = i;
          min = matrix[i][0];
        }
      }

      String result = "";
      System.out.println(printPath(result, matrix, m, n, 0, minIndex));

      // Min is the result (weight).
      System.out.println(min);
    }
  }

  public static String printPath(String result, int[][] matrix, int m, int n, int startColumn,
      int minRow) {
    // If this is the last column don't put a space.
    if (n - 1 == startColumn) {
      result += minRow + 1;
      return result;
    } else {
      result += (minRow + 1) + " ";
      // find next min
      int j = minRow;

      int[] indexes = new int[3];
      indexes[0] = (j - 1 < 0) ? m - 1 : j - 1;
      indexes[1] = j;
      indexes[2] = (j + 1 > m - 1) ? 0 : j + 1;
      int minIndex = Integer.MAX_VALUE;
      int minValue = Integer.MAX_VALUE;
      for (int i = 0; i < 3; i++) {
        if (minValue >= matrix[indexes[i]][startColumn + 1]) {
          if (minValue == matrix[indexes[i]][startColumn + 1]) {
            if (minIndex > indexes[i]) {
              minIndex = indexes[i];
            }
          } else {
            minIndex = indexes[i];
            minValue = matrix[indexes[i]][startColumn + 1];
          }

        }
      }

      return printPath(result, matrix, m, n, startColumn + 1, minIndex);
    }
  }
}
