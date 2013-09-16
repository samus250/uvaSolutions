import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class P10008 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    long n = scanner.nextInt();
    scanner.nextLine();
    HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();

      for (int j = 0; j < line.length(); j++) {
        char c = line.charAt(j);
        c = Character.toUpperCase(c);
        if (c >= 'A' && c <= 'Z') {
          if (hashMap.containsKey(c)) {
            hashMap.put(c, hashMap.get(c) + 1);
          } else {
            hashMap.put(c, 1);
          }
        }
      }
    }

    // Sort hashMap
    Set<Entry<Character, Integer>> entrySet = hashMap.entrySet();
    ArrayList<Entry<Character, Integer>> array = new ArrayList<Entry<Character, Integer>>(entrySet);
    Collections.sort(array, new Comparator<Entry<Character, Integer>>() {

      @Override
      public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
        if (o1.getValue() == o2.getValue()) {
          return o1.getKey().compareTo(o2.getKey());
        } else {
          return Integer.compare(o2.getValue(), o1.getValue());
        }
      }

    });

    for (Entry<Character, Integer> entry : array) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }

}
