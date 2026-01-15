enum Laptop {
      MacBook(2000), Asus(1200), XPS(1800), ThinkPad(1600), HP;
      
      private int price;

      private Laptop(){
            price = 1000;
      }

      private Laptop(int price){
            this.price = price;
      }

      public int getPrice(){
            return price;
      }
}
enum Day{
      Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}
public class EnumExample {


      public static void main(String[] args) {
            Day yesterday = Day.Sunday;
            Day today = Day.Monday;
            Day tomorrow = Day.Tuesday;

            System.out.println("Yesterday was " + yesterday);
            System.out.println("Today is " + today);
            System.out.println("Tomorrow will be " + tomorrow);

            Laptop[] laptops = Laptop.values();
            for(Laptop l : laptops){
                  System.out.println(l + " : " + l.getPrice());
            }
      }
}
