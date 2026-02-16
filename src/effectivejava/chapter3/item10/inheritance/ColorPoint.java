package effectivejava.chapter3.item10.inheritance;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

/** Pointに色の概念を追加したクラス */
public class ColorPoint extends Point {
  private final Color color;

  public ColorPoint(int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  // /**
  //  * 対称性が破られたequals
  //  * Point.equals(ColorPoint)の場合はtrue
  //  * ColorPoint.equals(Point)の場合型が違うので常にfalse
  //  */
  // @Override public boolean equals(Object o) {
  //     if (!(o instanceof ColorPoint))
  //         return false;
  //     return super.equals(o) && ((ColorPoint) o).color == color;
  // }

  /** 推移性が破られたequals */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Point)) return false;

    // If o is a normal Point, do a color-blind comparison
    if (!(o instanceof ColorPoint)) return o.equals(this);

    // o is a ColorPoint; do a full comparison
    return super.equals(o) && ((ColorPoint) o).color == color;
  }

  public static void main(String[] args) {
    ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
    Point p2 = new Point(1, 2);
    ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
    System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
  }
}
