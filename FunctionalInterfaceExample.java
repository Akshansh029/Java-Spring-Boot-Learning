@FunctionalInterface
interface A{
      void run();
}
// class B implements A{
//       @Override
//       public void run(){
//             System.out.println("Running...");
//       }
// }

public class FunctionalInterfaceExample {
      public static void main(String[] args) {
            // A obj = new B();
            // obj.run();

            // Same thing using Anonymous class
            A obj = new A(){
                  @Override
                  public void run(){
                        System.out.println("Running in anon class...");
                  }
            };
            obj.run();
      }
}
