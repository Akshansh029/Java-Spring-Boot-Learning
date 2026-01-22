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
                  c.increment();
            };

            Thread t1 = new Thread(obj, "Thread 1");
            Thread t2 = new Thread(obj, "Thread 2");

            t1.start();
            t2.start();

            System.out.println(c.getCount());
      }
}
