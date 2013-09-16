import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P392 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    do {
      String line = reader.readLine();
      // need to clean the input first
      String[] splitLine = line.split(" ");
      ArrayList<String> listOfCoeffs = new ArrayList<String>();
      for (int i = 0; i < splitLine.length; i++) {
        if (!splitLine[i].equals("")) {
          listOfCoeffs.add(splitLine[i]);
        }
      }
      solve(listOfCoeffs);
      System.out.println();
    } while (reader.ready());
  }

  public static String solve(ArrayList<String> line) {
    // splits individual number, length - 1 is max coeff
    boolean firstHasBeenPrinted = false;
    int maxExponent = line.size() - 1;
    int currentExponent = maxExponent;
    String currentExponentString = Integer.toString(currentExponent);
    for (int i = 0; i < line.size(); i++) {
      if (currentExponent != 0) {
        currentExponentString = Integer.toString(currentExponent);
      } else {
        currentExponentString = "";
      }

      String coeff = line.get(i);
      if (!coeff.equals("0")) {
        if (coeff.equals("1")) {
          System.out.print("x^" + currentExponentString);
          firstHasBeenPrinted = true;
        } else {
          // print the coeff, make sure you drop - sign
          if (coeff.charAt(0) == '-' && firstHasBeenPrinted) {
            System.out.print(coeff.substring(1)
                + (currentExponentString.equals("") ? "" : "x^" + currentExponentString));
            firstHasBeenPrinted = true;
          } else {
            System.out.print(coeff
                + (currentExponentString.equals("") ? "" : "x^" + currentExponentString));
            firstHasBeenPrinted = true;
          }
        }

        if (i != line.size() - 1) {
          String nextCoeff = line.get(i + 1);
          if (nextCoeff.charAt(0) == '-') {
            // print a minus sign.
            System.out.print(" - ");
          } else {
            System.out.print(" + ");
          }
        }
      }
      currentExponent--;
    }
    return null;
  }
}
