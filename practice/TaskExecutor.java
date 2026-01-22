package practice;
/*
Problem Statement
Create a task executor that:
- Runs 3 background tasks
- Each task:
      - Prints thread name
      - Sleeps for 1 second
      - Prints completion message

Rules
- Use lambda expression for Runnable
- Ensure main thread waits for all tasks to finish
*/

public class TaskExecutor {
      public static void main(String[] args) {
            Runnable t1 = () -> {
                  System.out.println(Thread.currentThread().getName());
                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                  }
                  System.out.println(Thread.currentThread().getName() + " completed execution");
            };

            Thread threadA = new Thread(t1, "ThreadA");
            Thread threadB = new Thread(t1, "ThreadB");
            Thread threadC = new Thread(t1, "ThreadC");

            threadA.start();
            threadB.start();
            threadC.start();
            try {
                  threadA.join();
                  threadB.join();
                  threadC.join();
            } catch (InterruptedException e) {
                  System.out.println(e.getMessage());
            }
      }
}
