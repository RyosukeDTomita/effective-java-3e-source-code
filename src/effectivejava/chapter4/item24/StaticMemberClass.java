package effectivejava.chapter4.item24;

public class StaticMemberClass {
  public static void main(String[] args) {
    Outer outer = new Outer();
    outer.test(); // OK
    // outer.InnerPrivate.hello(); // アクセス不可
    Outer.InnerPublic.hello(); // public かつstaticで宣言すると直接アクセスできるようになる
  }
}

class Outer {
  public String name1 = "Mike";
  private static String name2 = "Mike";

  // staticメンバークラス
  private static class InnerPrivate {
    static void hello() {
      System.out.println("hi");
    }

    // static void helloOuter() {
    //     System.out.println(name1); // Outerのインスタンスフィールドにはアクセスできない
    // }
    static void helloOuter() {
      System.out.println(name2); // Outerのstaticフィールドにはアクセスできる
    }
  }

  void test() {
    InnerPrivate.hello();
  }

  /** エンクロージングクラスと一緒に使うと有用なpublicのヘルパークラスとして使われることが多い。 */
  public static class InnerPublic {
    static void hello() {
      System.out.println("hi");
    }
  }
}
