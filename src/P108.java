import java.util.Scanner;

public class P108 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[][] a = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = scanner.nextInt();
      }
    }

    System.out.println(maxRectangleSum(a));
  }

  public static long maxRectangleSum(int[][] a) {
    long result = 0;

    return result;
  }
}
