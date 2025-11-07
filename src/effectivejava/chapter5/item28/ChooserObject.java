package effectivejava.chapter5.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

/**
 * ジェネリックを使わずにObject型で戻り値を取得してキャストが必要なアンチパターン
 */
public class ChooserObject {
  private final Object[] choiceArray;

  public ChooserObject(Collection choices) {
      choiceArray = choices.toArray();
  }

  public Object choose() {
      Random rnd = ThreadLocalRandom.current();
      return choiceArray[rnd.nextInt(choiceArray.length)];
  }

  public static void main(String[] args) {
      List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

      ChooserObject chooser = new ChooserObject(intList);

      for (int i = 0; i < 10; i++) {
          // キャストが必要
          Integer choice = (Integer) chooser.choose();
          System.out.println(choice);
      }
  }

}
