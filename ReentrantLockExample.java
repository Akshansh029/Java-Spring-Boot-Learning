import java.util.concurrent.locks.ReentrantLock;

class LockCounter{
    private final ReentrantLock lock = new ReentrantLock();
    int count;

    public void increment(){
        lock.lock();

        try{
//            System.out.println(Thread.currentThread().getName() + " incrementing the counter...");
            count++;
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockExample {


    public static void main(String[] args) {
        LockCounter counter = new LockCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                counter.increment();
            }
        }, "Thread1");
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                counter.increment();
            }
        }, "Thread2");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(counter.count);
        }
    }
}
