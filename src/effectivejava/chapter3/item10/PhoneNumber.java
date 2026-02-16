package effectivejava.chapter3.item10;

/** equalsの良い例 電話番号を表すクラス */
public final class PhoneNumber {
  private final short areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max) throw new IllegalArgumentException(arg + ": " + val);
    return (short) val;
  }

  // Object型を引数にする
  @Override
  public boolean equals(Object o) {
    // 引数が自分自身のオブジェクトへの参照であるか検査するために==を使うことでパフォーマンス最適化ができる。
    if (o == this) return true;
    // 引数が正しい型であるかを検査するためにinstanceofを使う。
    if (!(o instanceof PhoneNumber)) return false;
    // PhoneNumberにキャストしてフィールドを比較する。事前にinstanceofで型を検査しているので、ここでClassCastExceptionが発生することはない。
    PhoneNumber pn = (PhoneNumber) o;
    // クラスの意味のある全てのフィールドが等しいかを比較する。比較のコストが低い順に比較することでパフォーマンス最適化ができる。
    return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
  }
}
