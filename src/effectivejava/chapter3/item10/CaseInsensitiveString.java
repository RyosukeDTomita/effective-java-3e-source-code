package effectivejava.chapter3.item10;

import java.util.Objects;

/** 対称性が破られたequalsの例に使用するクラス Stringをラップし、大文字小文字を比較しないequalsを提供する */
public final class CaseInsensitiveString {
  private final String s;

  public CaseInsensitiveString(String s) {
    this.s = Objects.requireNonNull(s);
  }

  /** 対称性が破られたequals */
  @Override
  public boolean equals(Object o) {
    if (o instanceof CaseInsensitiveString)
      return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
    if (o instanceof String) return s.equalsIgnoreCase((String) o);
    return false;
  }

  public static void main(String[] args) {
    CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    String s = "polish";
    System.out.println("cis.equals(s): " + cis.equals(s)); // true
    System.out.println("s.equals(cis): " + s.equals(cis)); // false --> 対称性が破られている
  }
}
