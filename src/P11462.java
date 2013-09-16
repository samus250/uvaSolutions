import java.util.Scanner;

/**
 * Solves UVa problem 11462 "Age Sort".
 * 
 * @author samus250
 */
public class P11462 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    while (n != 0) {
      // Count the occurrences of each age.
      int[] countingArray = new int[101];
      for (int i = 0; i < n; i++) {
        countingArray[scanner.nextInt()]++;
      }

      // Build the sorted result string.
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < countingArray.length; i++) {
        for (int j = 0; j < countingArray[i]; j++) {
          result.append(i);
          result.append(' ');
        }
      }
      // Remove the last space, or else the verdict will be PE.
      result.deleteCharAt(result.length() - 1);

      // Print the result for the test case.
      System.out.println(result);
      n = scanner.nextInt();
      scanner.nextLine();
    }
    scanner.close();
  }
}
