import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Solves UVa problem 10131 "Is Bigger Smarter?".
 * 
 * @author samus250
 */
public class P10131 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Elephant> elephants = new ArrayList<Elephant>(1001);
    int size = 0;
    while (scanner.hasNextInt()) {
      int weight = scanner.nextInt();
      int iq = scanner.nextInt();
      elephants.add(new Elephant(size + 1, weight, iq));
      size++;
    }
    scanner.close();

    // Sort the elephants by decreasing IQ and decreasing weight.
    Collections.sort(elephants);

    // Now do LIS just like the Strategic Defense Initiative problem.
    int length[] = new int[size]; // index holds the size.
    int pred[] = new int[size];
    length[0] = 1;
    for (int i = 0; i < pred.length; i++) {
      pred[i] = -1;
    }

    int longestSequenceLength = 0;
    int longestSequenceFinishIndex = 0;

    for (int i = 1; i < size; i++) {
      int maxLength = 0;
      for (int j = 0; j < i; j++) {
        if (maxLength < length[j] && elephants.get(i).weight > elephants.get(j).weight) {
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

    // Now print the result
    StringBuffer buffer = new StringBuffer();
    buffer.append(Integer.toString(longestSequenceLength));
    buffer.append('\n');

    // Trace longest sequence, order will first be reversed.
    int[] sequence = new int[longestSequenceLength];
    int pointer = longestSequenceFinishIndex;
    int j = longestSequenceLength - 1;
    while (pointer >= 0) {
      sequence[j--] = elephants.get(pointer).index;
      pointer = pred[pointer];
    }

    // Add the sequence to the buffer.
    for (int i = 0; i < longestSequenceLength; i++) {
      buffer.append(Integer.toString(sequence[i]));
      buffer.append('\n');
    }
    System.out.print(buffer);
  }

  public static class Elephant implements Comparable<Elephant> {
    public int index;
    public int weight;
    public int iq;

    public Elephant(int index, int weight, int iq) {
      this.index = index;
      this.weight = weight;
      this.iq = iq;
    }

    /**
     * The Elephants must be ordered by decreasing IQ and decreasing weight initially.
     */
    @Override
    public int compareTo(Elephant b) {
      if (this.iq == b.iq) {
        return Integer.compare(b.weight, this.weight);
      } else {
        return Integer.compare(b.iq, this.iq);
      }
    }
  }
}
