// Creating thread using Thread class
class A extends Thread{
      @Override
      public void run(){
            for (int i = 0; i < 50; i++) {
                  System.out.println("ThreadA value: + " + i);
            }
            System.out.println("ThreadA execution completed");
      }
}

// Creating thread using Runnable interface
class B implements Runnable{
      @Override
      public void run(){
            for (int i = 0; i < 50; i++) {
                  System.out.println("ThreadB value: + " + i);
            }
            System.out.println("ThreadB execution completed");
      }
}

public class ThreadDemo {
      public static void main(String[] args) {
            A obj = new A();
            B obj1 = new B();
            Thread t = new Thread(obj1);
            obj.start();
            t.start();
      }
}
