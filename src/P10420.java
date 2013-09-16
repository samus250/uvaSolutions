import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Solves UVa problem 10420 "List of Conquests".
 * 
 * @author samus250
 */
public class P10420 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    // Also store the countries in an arraylist so that it can be easily sorted.
    ArrayList<String> countryList = new ArrayList<String>();
    HashMap<String, HashSet<String>> countryToWomanMap = new HashMap<String, HashSet<String>>();

    // Get and structure all the input.
    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      String[] splitLine = line.split(" ");
      String country = splitLine[0];

      // Initialize woman HashSet if it does not exist for that country.
      HashSet<String> womanHashSet = countryToWomanMap.get(country);
      if (womanHashSet == null) {
        womanHashSet = new HashSet<String>();
        countryToWomanMap.put(country, womanHashSet);
        countryList.add(country);
      }

      // Add woman name to specific country's HashSet. The name consists of the rest of the string.
      String name = "";
      for (int j = 1; j < splitLine.length - 1; j++) {
        name += splitLine[j] + " ";
      }
      name += splitLine[splitLine.length - 1];
      womanHashSet.add(name);
    }
    scanner.close();

    // Sort the countries in alphabetical order.
    Collections.sort(countryList);

    for (int j = 0; j < countryList.size(); j++) {
      String country = countryList.get(j);
      System.out.println(country + " " + countryToWomanMap.get(country).size());
    }
  }
}
