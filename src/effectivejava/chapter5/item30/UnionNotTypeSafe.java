package effectivejava.chapter5.item30;

import java.util.*;

public class UnionNotTypeSafe {

  // Uses raw types - unacceptable! (Item 26)
  public static Set union(Set s1, Set s2) {
    Set result = new HashSet(s1);
    result.addAll(s2);
    return result;
  }

  // Simple program to exercise raw-type method
  public static void main(String[] args) {
    Set<String> guys = Set.of("Tom", "Dick", "Harry");
    Set<String> stooges = Set.of("Larry", "Moe", "Curly");
    Set<String> aflCio = union(guys, stooges);
    System.out.println(aflCio);
  }
}
