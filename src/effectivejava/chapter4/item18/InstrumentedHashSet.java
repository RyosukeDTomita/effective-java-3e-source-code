package effectivejava.chapter4.item18;

import java.util.*;

/** 不適切な継承の例 */
public class InstrumentedHashSet<E> extends HashSet<E> {
  private int addCount = 0;

  public static void main(String[] args) {
    InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
    s.addAll(List.of("Snap", "Crackle", "pop"));
    System.out.println(s.getAddCount()); // 想定外に6が得られる。
  }

  public InstrumentedHashSet() {}

  public InstrumentedHashSet(int initCap, float loadFactor) {
    super(initCap, loadFactor);
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  /**
   * Listに一括追加を行うメソッド
   * HashSetのaddAll()の内部でadd()が使われており、この時に呼び出されるadd()はsuper.add()ではなく、Overrideされたadd()である。
   * 想定外にadd()が呼び出されることで、addCountが不正に増加してしまう。
   */
  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }
}
