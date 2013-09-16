import java.util.Scanner;
import java.util.Stack;

/**
 * Solves UVa problem 673, "Parentheses Balance".
 * 
 * @author samus250
 */
public class P673 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      System.out.println(solve(line) ? "Yes" : "No");
    }
    scanner.close();
  }

  /**
   * Returns whether the expression is correctly balanced.
   * 
   * @param line The expression of parenthesis and brackets.
   * @return True if it is correctly balanced, false otherwise.
   */
  public static boolean solve(String line) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);

      if (isOpening(c)) {
        // Push opening char to stack.
        stack.push(c);
      } else {
        // Verify closing parenthesis.
        if (stack.isEmpty()) {
          return false;
        } else {
          char cInStack = stack.pop();
          if (map(cInStack) != c) {
            return false;
          }
        }
      }
    }

    return stack.isEmpty();
  }

  /**
   * Returns whether a given char is an opening char.
   * 
   * @param c The char to classify.
   * @return True if it is an opening char, false otherwise.
   */
  public static boolean isOpening(char c) {
    switch (c) {
    case '(':
    case '[':
      return true;
    default:
      return false;
    }
  }

  /**
   * Maps opening chars to closing chars.
   * 
   * @param c The opening char.
   * @return The corresponding closing char.
   */
  public static char map(char c) {
    switch (c) {
    case '(':
      return ')';
    case '[':
      return ']';
    default:
      return ' ';
    }
  }
}
