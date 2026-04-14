package effectivejava.chapter5.item30;

import java.util.function.UnaryOperator;

/**
 * 1つしかないstaticフィールドを別の型として使いまわす例
 */
public class GenericSingletonFactory {
  /**
   * Generic singleton factory pattern
   * もらった引数をそのまま返す関数
   * NOTE: UnaryOperator<T>は、引数と返り値が同じ型の関数を表す関数型インターフェース
   */
  private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

  @SuppressWarnings("unchecked")
  public static <T> UnaryOperator<T> identityFunction() {
    return (UnaryOperator<T>) IDENTITY_FN;
  }

  // Sample program to exercise generic singleton
  public static void main(String[] args) {
    String[] strings = {"jute", "hemp", "nylon"};
    UnaryOperator<String> sameString = identityFunction();
    for (String s : strings) System.out.println(sameString.apply(s)); // NOTE: apply()の呼び出しが終わればTはGCされる

    Number[] numbers = {1, 2.0, 3L};
    UnaryOperator<Number> sameNumber = identityFunction();
    for (Number n : numbers) System.out.println(sameNumber.apply(n));
  }
}
