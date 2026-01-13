abstract class Animal{
      abstract void sound();
      public void eat(){
            System.out.println("Animal is eating...");
      }
}

class Cat extends Animal{
      void sound(){
            System.out.println("Meow meow...");
      }
      void move(){
            System.out.println("Cat is moving...");
      }
}

public class Abstract {
      public static void main(String[] args) {
            Cat cat = new Cat();
            cat.sound();
            cat.eat();
            cat.move();
      }
}
