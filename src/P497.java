import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class P497 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(reader.readLine());
    reader.readLine();
    
    ArrayList<Integer> missles;
    for (int i = 0; i < cases; i++) {
      String nextLine = reader.readLine();
      missles = new ArrayList<Integer>();
      while (nextLine.length() > 0) {
        missles.add(Integer.parseInt(nextLine));
        if (reader.ready()) {
          nextLine = reader.readLine();
        } else {
          break;
        }
      }
      
      solve(missles);
      if (i < cases - 1) {
        System.out.println();
      }
    }
  }

  public static void solve(ArrayList<Integer> missles) {
    int size = missles.size();
    int[] length = new int[size];
    int[] pred = new int[size];
    length[0] = 1;
    for (int i = 0; i < pred.length; i++) {
      pred[i] = -1;
    }
    int longestSequenceLength = 0;
    int longestSequenceFinishIndex = 0;
    
    for (int i = 1; i < size; i++) {
      int maxLength = 0;
      for (int j = 0; j < i; j++) {
        if (maxLength < length[j] && missles.get(i) > missles.get(j)) {
          pred[i] = j;
          maxLength = length[j];
        }
      }
      length[i] = maxLength + 1;
      if (longestSequenceLength < length[i]) {
        longestSequenceLength = length[i];
        longestSequenceFinishIndex = i;
      }
    }
    
    if (longestSequenceLength == 0) {
      longestSequenceLength = 1;
    }
    
    // Now just follow the pointers from longestSequenceFinishIndex.
    int[] sequence = new int[longestSequenceLength];
    System.out.print("Max hits: " + longestSequenceLength + "\n");
    int pointer = longestSequenceFinishIndex;
    int i = longestSequenceLength - 1;
    while (pointer >= 0) {
      sequence[i--] = missles.get(pointer);
      pointer = pred[pointer];
    }
    StringBuilder builder = new StringBuilder();
    for (i = 0; i < longestSequenceLength; i++) {
      builder.append(Integer.toString(sequence[i]));
      builder.append('\n');
    }
    System.out.print(builder);
  }
}
