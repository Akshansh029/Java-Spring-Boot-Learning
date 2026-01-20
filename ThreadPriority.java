// Creating thread using Thread class
class A extends Thread{
      @Override
      public void run(){
            for (int i = 1; i <= 5; i++) {
                  System.out.println("ThreadA value: " + i);
            }
            System.out.println("ThreadA execution completed");
      }
}

class B extends Thread{
      @Override
      public void run(){
            for (int i = 1; i <= 5; i++) {
                  System.out.println("ThreadB value: " + i);
            }
            System.out.println("ThreadB execution completed");
      }
}

class C extends Thread{
      @Override
      public void run(){
            for (int i = 1; i <= 5; i++) {
                  System.out.println("ThreadC value: " + i);
            }
            System.out.println("ThreadC execution completed");
      }
}

public class ThreadPriority {
      public static void main(String[] args) {
            A objA = new A();
            B objB = new B();
            C objC = new C();
            System.out.println("Default priority of Thread A: " + objA.getPriority());
            System.out.println("Default priority of Thread B: " + objB.getPriority());
            System.out.println("Default priority of Thread C: " + objC.getPriority());
            objA.setPriority(Thread.MIN_PRIORITY);
            objB.setPriority(Thread.NORM_PRIORITY);
            objC.setPriority(Thread.MAX_PRIORITY);
            System.out.println("New priority of Thread A: " + objA.getPriority());
            System.out.println("New priority of Thread B: " + objB.getPriority());
            System.out.println("New priority of Thread C: " + objC.getPriority());
            objA.start();
            objB.start();
            objC.start();
      }
}
