import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solves UVa problem 382 "Perfection".
 * 
 * @author samus250
 */
public class P382 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    HashMap<Integer, String> resultMap = new HashMap<Integer, String>();
    int maxDigits = 1;

    // Get input. Do not assume it is in a single line. Do not assume that
    // the last value will be 0.
    while (scanner.hasNextInt()) {
      int number = scanner.nextInt();
      if (number == 0) {
        break;
      } else {
        numbers.add(number);
      }
    }

    // Populate result map and figure out what is the maximum digit count.
    for (int i = 0; i < numbers.size(); i++) {
      int number = numbers.get(i);
      int numberOfDigits = (int) Math.log10(number) + 1;
      if (maxDigits < numberOfDigits) {
        maxDigits = numberOfDigits;
      }
      resultMap.put(number, solve(number));
    }

    // Print results.
    System.out.println("PERFECTION OUTPUT");
    for (int n : numbers) {
      System.out.format("%" + maxDigits + "d  " + resultMap.get(n) + "\n", n);
    }
    System.out.println("END OF OUTPUT");
    scanner.close();
  }

  /**
   * Solve the problem for a single number n.
   * 
   * @param n The number to solve.
   * @return Either "DEFICIENT", "ABUNDANT" or "PERFECT" if the number is deficient, abundant, or
   * perfect.
   */
  public static String solve(int n) {
    long sum = 0;
    for (int number : getDivisors(n)) {
      sum += number;
    }

    if (sum < n) {
      return "DEFICIENT";
    } else if (sum > n) {
      return "ABUNDANT";
    } else {
      return "PERFECT";
    }
  }

  /**
   * Find proper divisors of an integer.
   * 
   * @param n Integer whose proper divisors will be generated.
   * @return List of all proper divisors of n.
   */
  public static ArrayList<Integer> getDivisors(int n) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    // 1 is deficient.
    if (n == 1) {
      return result;
    }
    result.add(1); // 1 is always a divisor.
    int maxDivisor = (int) Math.sqrt(n);
    for (int i = 2; i <= maxDivisor; i++) {
      if (n % i == 0) {
        result.add(i);
        result.add(n / i);
        maxDivisor = n / i - 1;
      }
    }
    return result;
  }
}
