package effectivejava.chapter5.item26;

import java.util.*;

/** 原型のListを使用するとコンパイル時にエラーが発見されず、実行時に例外が発生する例 */
public class Raw {
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    // safeAdd(strings, 42); // コンパイルエラーになるので実行前に発見できる。
    safeAdd(strings, "42");
    String s = strings.get(0); // 安全に取得できる。
    unsafeAdd(strings, Integer.valueOf(42));
    String s2 = strings.get(1); // コンパイラがキャストを行う際(実行時)にエラーがでる。
  }

  /**
   * 原型を使う良くない実装
   *
   * @param list
   * @param o
   */
  private static void unsafeAdd(List list, Object o) {
    list.add(o);
  }

  /**
   * ジェネリックスを使った安全な実装
   *
   * @param list
   * @param s
   */
  private static void safeAdd(List<String> list, String s) {
    list.add(s);
  }
}
