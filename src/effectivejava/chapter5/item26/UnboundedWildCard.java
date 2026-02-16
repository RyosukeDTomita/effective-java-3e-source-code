package effectivejava.chapter5.item26;

import java.util.Set;

/** 非境界型ワイルドカードの使い方 */
public class UnboundedWildCard {

  /**
   * 不明な型に対して原型を使う
   *
   * @param s1
   * @param s2
   * @return
   */
  public static int numElementsInCommon(Set s1, Set s2) {
    int result = 0;
    for (Object o1 : s1) if (s2.contains(o1)) result++;
    return result;
  }

  /**
   * 非境界型ワイルドカードを使う安全な実装
   *
   * @param s1
   * @param s2
   * @return
   */
  public static int numElementsInCommonFixed(Set<?> s1, Set<?> s2) {
    int result = 0;
    for (Object o1 : s1) if (s2.contains(o1)) result++;
    return result;
  }

  public static void main(String[] args) {
    Set<Integer> set1 = Set.of(1, 2, 3);
    Set<Integer> set2 = Set.of(2, 3, 4);
    System.out.println(numElementsInCommon(set1, set2));

    Set<String> setFixed1 = Set.of("apple", "banana", "cherry");
    Set<String> setFixed2 = Set.of("banana", "cherry", "date");
    System.out.println(numElementsInCommonFixed(setFixed1, setFixed2));
  }
}
