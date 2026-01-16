@FunctionalInterface
interface A{
      void run();
}

@FunctionalInterface
interface B{
      int add(int i, int j);
}

public class LambdaExpressions {
      public static void main(String[] args) {
      
            // Using Lambda expressions
            A obj = () -> {
                  System.out.println("Running in Lambda Expression...");
            };
            obj.run();

            B obj1 = (i, j) -> {
                  return i+j;
            };
            System.out.println(obj1.add(2, 6));
      }
      
}
