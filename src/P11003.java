import java.util.ArrayList;
import java.util.Scanner;

public class P11003 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      ArrayList<Box> boxes = new ArrayList<Box>();
      for (int i = 0; i < n; i++) {
        Box box = new Box();
        box.weight = scanner.nextInt();
        box.load = scanner.nextInt();
        boxes.add(box);
      }

    }
  }

  public static class Box {
    public int weight;
    public int load;
  }
}
