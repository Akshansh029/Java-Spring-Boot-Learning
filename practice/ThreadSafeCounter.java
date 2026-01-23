package practice;
/*
Create:
- Counter class with increment()
- Start multiple threads incrementing the counter
- Ensure final count is correct
*/

class Counter {
      private int count;

      public synchronized void increment(){
            count++;
      }

      public int getCount(){
            return count;
      }
}

public class ThreadSafeCounter {
      public static void main(String[] args) {
            Counter c = new Counter();
            
            Runnable obj = () -> {
                 for (int i = 0; i < 10000; i++) {
                        c.increment();
                 }
            };

            Thread t1 = new Thread(obj, "Thread 1");
            Thread t2 = new Thread(obj, "Thread 2");

            t1.start();
            t2.start();
            try {
                  t1.join();
                  t2.join();
            } catch (InterruptedException e) {
                  System.out.println(e.getMessage());
            }

            System.out.println(c.getCount());
      }
}
