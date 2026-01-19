class A{
      String name = "Akshansh";
      int num = 10;

      public A(){
            System.out.println("A constructor");
      }
}

class B extends A{
      public B(){
            System.out.println(super.num);
            System.out.println("B constructor");
      }
}
public class Super{
      public static void main(String[] args) {
            B obj = new B();
            System.out.println(obj.hashCode());
      }
}