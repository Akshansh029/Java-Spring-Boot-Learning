public class ThreadJoin {
      public static void main(String[] args) {
            Runnable ThreadA = () -> {
                  for (int i = 1; i <= 5; i++) {
                        System.out.println("Thread A value: " + i);
                  }
                  System.out.println("Thread A execution completed");
            };
            Runnable ThreadB = () -> {
                  for (int i = 1; i <= 5; i++) {
                        System.out.println("Thread B value: " + i);
                  }
                  System.out.println("Thread B execution completed");
            };

            Thread t1 = new Thread(ThreadA);
            Thread t2 = new Thread(ThreadB);

            t1.start();
            try {
                  t1.join();
            } catch (InterruptedException e) {
                  System.out.println(e.getMessage());
            }
            t2.start();
      }
}
