package effectivejava.chapter8.item55;

import java.util.*;

/** nullを返す代わりにOptionalを返す例 */
public class Max {
  /**
   * コレクション中の最大値を返す(Exceptionバージョン)
   *
   * @param <E>
   * @param c
   * @return
   */
  public static <E extends Comparable<E>> E maxException(Collection<E> c) {
    if (c.isEmpty()) throw new IllegalArgumentException("Empty collection"); // nullの代わりに例外をスロー

    E result = null;
    for (E e : c) if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);

    return result;
  }

  /**
   * コレクション中の最大値を返す(Optionalバージョン)
   *
   * @param <E>
   * @param c
   * @return
   */
  public static <E extends Comparable<E>> Optional<E> maxOptional(Collection<E> c) {
    if (c.isEmpty()) return Optional.empty(); // 空のOptionalを返す

    E result = null;
    for (E e : c) if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);

    return Optional.of(result); // nullではないvalueを持つOptionalを返す
  }

  /**
   * コレクション中の最大値をOptionalで返す(ストリームバージョン)
   *
   * @param <E>
   * @param c
   * @return
   */
  public static <E extends Comparable<E>> Optional<E> maxOptionalStream(Collection<E> c) {
    return c.stream().max(Comparator.naturalOrder());
  }

  public static void main(String[] args) {
    // 例外をスローするバージョン
    List<String> words = Arrays.asList(); // 空のリスト
    try {
      maxException(words);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    // Optionalを返すバージョン
    List<String> words2 = Arrays.asList(); // 空のリスト
    String maxString2 = maxOptional(words2).orElse("No words..."); // 空の場合はorElseでデフォルト値を決める。
    System.out.println(maxString2);

    // Optionalを返すバージョン(ストリーム)
    List<String> words3 = Arrays.asList(); // 空のリスト
    String maxString3 = maxOptionalStream(words3).orElse("No words...");
    System.out.println(maxString3);
  }
}
