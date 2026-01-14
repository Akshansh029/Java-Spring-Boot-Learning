package practice;

abstract class Vehicle{
      abstract double calculateRentalPrice(int days);
}

class Car extends Vehicle{
      private final int rentPrice = 2000;
      @Override
      public double calculateRentalPrice(int days){
            if(days <= 0){
                  throw new IllegalArgumentException("Days cannot be zero or negative");
            }
            return rentPrice * days;
      }
}
class Bike extends Vehicle{
      private final int rentPrice = 1200;
      @Override
      public double calculateRentalPrice(int days){
            if(days <= 0){
                  throw new IllegalArgumentException("Days cannot be zero or negative");
            }
            return rentPrice * days;
      }
}
class Truck extends Vehicle{
      private final int rentPrice = 3500;
      @Override
      public double calculateRentalPrice(int days){
            if(days <= 0){
                  throw new IllegalArgumentException("Days cannot be zero or negative");
            }
            return rentPrice * days;
      }
}

public class RentalSystem {
      public static void main(String[] args) {
            Vehicle[] vehicles = {new Car(), new Bike(), new Truck()};

            int[] days = {3, 5, 2};
            
            for (int i = 0; i < vehicles.length; i++) {
                  try {
                        System.out.println(vehicles[i].calculateRentalPrice(days[i]));
                  } catch (Exception e) {
                        System.out.println(e.getMessage());
                  }
            }
      }
}