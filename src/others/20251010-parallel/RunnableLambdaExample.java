public class RunnableLambdaExample {
  public static void main(String[] args) {
    // Runnableインターフェースをラムダ式で実装
    Runnable task =
        () -> {
          for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " → " + i);
            try {
              Thread.sleep(500); // 0.5秒待つ
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
        };

    Thread t1 = new Thread(task, "Worker-1");
    Thread t2 = new Thread(task, "Worker-2");

    t1.start();
    t2.start();
  }
}
