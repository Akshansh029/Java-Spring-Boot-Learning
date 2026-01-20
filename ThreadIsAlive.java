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


public class ThreadIsAlive {
      public static void main(String[] args) {
            A objA = new A();
            B objB = new B();
            objA.start();
            // objB.start();
            System.out.println(objA.isAlive());
            System.out.println(objB.isAlive());
      }
}
