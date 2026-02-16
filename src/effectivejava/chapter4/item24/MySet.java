package effectivejava.chapter4.item24;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** 非staticメンバークラスの典型的な使い方
 * エンクロージングクラスのインスタンスを関係のないクラスのインスタンスとして見なせるアダプターを定義
 **/
public class MySet<E> extends AbstractSet<E> {

  private E[] elements;
  private int size = 0;

  @SuppressWarnings("unchecked")
  public MySet(int capacity) {
    this.elements = (E[]) new Object[capacity];
  }

  @Override
  public boolean add(E e) {
    if (size < elements.length) {
      elements[size++] = e;
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  /** 非staticメンバークラスを使ってイテレータを実装 MyIteratorはエンクロージングインスタンス(MySet)にアクセスできる */
  @Override
  public Iterator<E> iterator() {
    return new MyIterator();
  }

  /** 非staticメンバークラスとして実装されたイテレータ エンクロージングクラスのelementsとsizeに暗黙的にアクセスできる */
  private class MyIterator implements Iterator<E> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < size; // エンクロージングインスタンスのsizeにアクセス
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return elements[cursor++]; // エンクロージングインスタンスのelementsにアクセス
    }
  }

  public static void main(String[] args) {
    MySet<String> set = new MySet<>(5);
    set.add("A");
    set.add("B");
    set.add("C");

    System.out.println("MySetの要素:");
    for (String s : set) { // iteratorが使われる
      System.out.println(s);
    }
  }
}
