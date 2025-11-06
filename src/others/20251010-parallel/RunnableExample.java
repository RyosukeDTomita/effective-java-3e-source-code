import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println("Thread Name: " + Thread.currentThread().getName() + " time: " + formattedTime);
    }
}

/**
 * Runnableインターフェースを実装したスレッド並列処理の例
 * Threadクラスを継承する場合と異なり、継承制限がない。
 * NOTE: Javaの場合、継承は単一継承のみ可能であるが、インターフェースは多重継承が可能である。
 */
public class RunnableExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        t.start(); // NOTE: start()が新しいスレッドを作る。
        System.out.println("main Thread: " + Thread.currentThread().getName() + " time: " + formattedTime);
        myRunnable.run(); // runを直接呼ぶと同じスレッドで実行される。
    }
}