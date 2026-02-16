package effectivejava.chapter3.item11;

import java.util.*;

/** hashCodeをオーバーライドしないことで、HashMapが正しく動作しなくなる例 */
public final class PhoneNumberNohashCode {
  private final short areaCode, prefix, lineNum;

  public PhoneNumberNohashCode(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  private static short rangeCheck(int val, int max, String arg) {
    if (val < 0 || val > max) throw new IllegalArgumentException(arg + ": " + val);
    return (short) val;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof PhoneNumberNohashCode)) return false;
    PhoneNumberNohashCode pn = (PhoneNumberNohashCode) o;
    return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
  }

  public static void main(String[] args) {
    Map<PhoneNumberNohashCode, String> m = new HashMap<>();
    m.put(new PhoneNumberNohashCode(707, 867, 5309), "Jenny");
    System.out.println(m.get(new PhoneNumberNohashCode(707, 867, 5309)));
  }
}
