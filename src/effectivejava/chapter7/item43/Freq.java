package effectivejava.chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

/**
 * メソッド参照とlambdaの比較
 */
public class Freq {
  public static void main(String[] args) {
    Map<String, Integer> frequencyTable = new TreeMap<>();

    for (String s : args) frequencyTable.merge(s, 1, (count, incr) -> count + incr); // Lambda
    System.out.println(frequencyTable);

    // メソッド参照を使用して同じことを行う
    frequencyTable.clear();
    for (String s : args) frequencyTable.merge(s, 1, Integer::sum); // Method reference
    System.out.println(frequencyTable);
  }
}
