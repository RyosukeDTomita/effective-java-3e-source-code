import java.time.Instant;

public final class Sub extends Super {
  private final Instant instant;

  /**
   * NOTE: Javaのサブクラスのコンストラクタは最初にSUperクラスのコンストラクタを呼び出すというルールがある。
   * そのため、superクラスのコンストラクタがsupreクラスのoverrideMe()を呼び出し、null
   */
  Sub() {
    instant = Instant.now();
  }

  @Override
  public void overrideMe() {
    System.out.println(instant);
  }

  public static void main(String[] args) {
    Sub sub = new Sub();
    sub.overrideMe();
  }
}
