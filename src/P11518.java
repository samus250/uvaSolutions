import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solves UVa problem 115518 "Dominos 2".
 * 
 * @author samus250
 */
public class P11518 {
  static HashMap<Integer, ArrayList<Integer>> map;
  static boolean[] knocked;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int cases = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < cases; i++) {
      String[] split = scanner.nextLine().split("\\s");

      int n = Integer.parseInt(split[0]);
      int m = Integer.parseInt(split[1]);
      int l = Integer.parseInt(split[2]);

      map = new HashMap<Integer, ArrayList<Integer>>();

      // Fill up the adjacency map. Each key maps to a list of dominos that are knocked it.
      for (int j = 0; j < m; j++) {
        String[] mLine = scanner.nextLine().split("\\s");
        int num1 = Integer.parseInt(mLine[0]);
        int num2 = Integer.parseInt(mLine[1]);

        if (map.containsKey(num1)) {
          map.get(num1).add(num2);
        } else {
          ArrayList<Integer> newList = new ArrayList<Integer>();
          newList.add(num2);
          map.put(num1, newList);
        }
      }

      knocked = new boolean[n + 1];

      // Knock the dominos by hand.
      for (int j = 0; j < l; j++) {
        int num = Integer.parseInt(scanner.nextLine());
        markFallen(num);
      }

      // Count the dominos that fell.
      int answer = 0;
      for (int j = 0; j < knocked.length; j++) {
        if (knocked[j]) {
          answer++;
        }
      }

      System.out.println(answer);
    }
    scanner.close();
  }

  /**
   * Main graph traversal algorithm. It manually knocks the domino and then knocks the dominos that
   * are knocked by the given domino.
   * 
   * @param The domino where the traversal will be started.
   */
  private static void markFallen(int num) {
    if (!knocked[num]) {
      knocked[num] = true;
      ArrayList<Integer> list = map.get(num);
      if (list != null) {
        for (int i = 0; i < list.size(); i++) {
          markFallen(list.get(i));
        }
      }
    }
  }

}