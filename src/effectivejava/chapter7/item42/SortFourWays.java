package effectivejava.chapter7.item42;

import static java.util.Comparator.*;
import static java.util.Comparator.comparingInt;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Sorting with function objects (Pages 193-4)
public class SortFourWays {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("Hello", "Hi", "Hey", "Hola");

    // 無名クラスを使ったコンパレータ
    Collections.sort(
        words,
        new Comparator<String>() {
          public int compare(String s1, String s2) {
            return Integer.compare(s1.length(), s2.length());
          }
        });
    System.out.println(words);
    Collections.shuffle(words);

    // コンパレータ構築メソッド using lambda
    Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    System.out.println(words);
    Collections.shuffle(words);

    // Collections.sort(words, comparingInt(String::length));
    // System.out.println(words);
    // Collections.shuffle(words);

    // words.sort(comparingInt(String::length));
    // System.out.println(words);
  }
}
