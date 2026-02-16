import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class MyThread extends Thread {
  @Override
  public void run() {
    LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
    String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    System.out.println(
        "Thread Name: " + Thread.currentThread().getName() + " time: " + formattedTime);
  }
}

/** Threadクラスを継承したスレッド並列処理の例 */
public class ThreadExample {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
    String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

    MyThread t = new MyThread();
    t.start(); // NOTE: start()が新しいスレッドを作る。
    System.out.println(
        "main Thread: " + Thread.currentThread().getName() + " time: " + formattedTime);
    t.run(); // runを直接呼ぶと同じスレッドで実行される。
  }
}
