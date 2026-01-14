class Animal{
      void eat(){
            System.out.println("Animal is eating...");
      }
}

class Dog extends Animal{
      @Override
      void eat(){
            System.out.println("Dog is eating...");
      }
}

public class Binding {
      public static void main(String[] args) {
            Dog a1 = new Dog();     // Dog is eating
            a1.eat();
            Animal a2 = new Dog();  // Dog is eating
            a2.eat();
            Animal a3 = new Animal();     // Animal is eating
            a3.eat();
      }     
}
