package effectivejava.chapter5.item30;

import java.util.*;

// Using a recursive type bound to express mutual comparability (Pages 137-8)
public class RecursiveTypeBound {
  // Returns max value in a collection - uses recursive type bound
  public static <E extends Comparable<E>> E max(Collection<E> c) {
    if (c.isEmpty()) throw new IllegalArgumentException("Empty collection");

    E result = null;
    for (E e : c) if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);

    return result;
  }

  public static void main(String[] args) {
    List<String> sampleList = Arrays.asList("a", "b", "c"); // c
    System.out.println(max(sampleList));

    List<String> emptyList = Arrays.asList();
    System.out.println(max(emptyList)); // IllegalArgumentException


  }
}
