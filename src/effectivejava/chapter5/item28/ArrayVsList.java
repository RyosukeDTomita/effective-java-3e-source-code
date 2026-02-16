package effectivejava.chapter5.item28;

public class ArrayVsList {
  public static void main(String[] args) {
    Object[] objectArray = new Long[1];
    objectArray[0] = "I don't fit in"; // ArrayStoreExceptionが発生(配列は実行時まで誤りに気が付かない。)
    System.out.println(objectArray[0]);

    List<Object> objectList = new ArrayList<Long>();
    objectList.add("I don't fit in"); // コンパイルエラー
  }
}
