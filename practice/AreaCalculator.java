package practice;
/*
Problem Statement:
Create an abstract class Shape with:
- abstract method calculateArea()

Create subclasses:
- Circle
- Rectangle
- Triangle

Driver Class:
- Create objects using Shape reference
- Print area of each shape
 */

abstract class Shape{
      public abstract double calculateArea();
}

class Circle extends Shape{
      private final double PI = 3.14;
      private int radius;

      public Circle(int r){
            if(r <= 0){
                  throw new IllegalArgumentException("Radius cannot be zero or negative");
            }
            this.radius = r;
      }

      @Override public double calculateArea(){
            return PI * radius * radius;
      }
}
class Rectangle extends Shape{
      private int length;
      private int width;

      public Rectangle(int l, int w){
            if(l <= 0 || w <= 0){
                  throw new IllegalArgumentException("Length or Width cannot be zero or negative");
            }
            this.length = l;
            this.width = w;
      }

      @Override public double calculateArea(){
            return length * width;
      }
}
class Triangle extends Shape{
      private int height;
      private int base;

      public Triangle(int h, int b){
            if(h <= 0 || b <= 0){
                  throw new IllegalArgumentException("Height or Base cannot be zero or negative");
            }
            this.height = h;
            this.base = b;
      }

      @Override public double calculateArea(){
            return 0.5 * height * base;
      }
}

public class AreaCalculator {
      
      public static void main(String[] args) {
            Shape cir = new Circle(2);
            Shape rec = new Rectangle(4, 3);
            Shape tri = new Triangle(6, 4);
            
            System.out.println(cir.calculateArea());
            System.out.println(rec.calculateArea());
            System.out.println(tri.calculateArea());
      }
}
