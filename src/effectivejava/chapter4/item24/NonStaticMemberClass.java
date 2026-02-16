package effectivejava.chapter4.item24;

public class NonStaticMemberClass {
  public static void main(String[] args) {
    // 非staticメンバークラスは、エンクロージングクラスのインスタンスを生成してからでないとインスタンス化できない
    Outer outer = new Outer();
    Outer.InnerPrivate inner = outer.new InnerPrivate();

    inner.hello();
    inner.helloOuter(); // エンクロージングインスタンスのメソッドやフィールドにアクセスできる
  }
}

class Outer {
  private String name = "Mike";

  /** 非staticメンバークラス 個々のインスタンスはエンクロージングインスタンスと暗黙に関連付けされている */
  public class InnerPrivate {
    void hello() {
      System.out.println("hi");
    }

    /** 非staticメンバークラスはエンクロージングクラスのすべてのフィールドとメソッドにアクセスできることを示すサンプル */
    void helloOuter() {
      outerTest();
      // エンクロージングインスタンスへの参照を得る（修飾されたthis構文）
      System.out.println(Outer.this.name);
      Outer.this.outerTest();
    }
  }

  public void outerTest() {
    System.out.println("Outer");
  }
}
