package practice;

import java.util.HashMap;
import java.util.Map;

/*
Create:
- enum Category { ELECTRONICS, GROCERY, CLOTHING }
- Map<Integer, Product>

Tasks
- Add products
- Remove products
- Display products grouped by category
*/

enum Category { ELECTRONICS, GROCERY, CLOTHING }

class Product{
      private int id;
      private String name;
      private double price;
      private Category category;

      public Product(int i, String n, double p, Category c){
            if(n.isEmpty()){
                  throw new IllegalArgumentException("Product name cannot be empty");
            }
            if(p <= 0){
                  throw new IllegalArgumentException("Product price must be atleast Rs.1");
            }
            if(c == null){
                  throw new IllegalArgumentException("Category cannot be null");
            }
            if(i <= 0){
                  throw new IllegalArgumentException("Product id must be natural number");
            }
            this.id = i;
            this.name = n;
            this.price = p;
            this.category = c;
      }

      public int getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public double getPrice() {
            return price;
      }

      public Category getCategory() {
            return category;
      }
}

class Inventory{
      private Map<Integer, Product> products = new HashMap<>();
      
      public void add(Product p){
            if(p == null){
                  throw new IllegalArgumentException("Product cannot be null");
            }
            products.put(p.getId(), p);
      }
      
      public void remove(int id){
            products.remove(id);
      }

      public void display(){
          for (Category value : Category.values()) {
              System.out.println("Category: " + value);
              products.values().stream()
                  .filter(p -> p.getCategory() == value)
                  .forEach(p -> {
                        System.out.printf("Name: %s, Price: %.2f\n", p.getName(), p.getPrice());
                  });
              System.out.println();
            }
      }
}

public class InventoryManagement {
      public static void main(String[] args) {
            Inventory inv = new Inventory();

            try {
                  inv.add(new Product(1, "Sweatshirt", 1100, Category.CLOTHING));
                  inv.add(new Product(2, "Leather Jacket", 2000, Category.CLOTHING));
                  inv.add(new Product(3, "Milk", 100, Category.GROCERY));
                  inv.add(new Product(4, "Mobile", 18000, Category.ELECTRONICS));
                  inv.add(new Product(5, "Fruits", 250, Category.GROCERY));
                  inv.add(new Product(6, "Chips", 50, Category.GROCERY));
                  inv.add(new Product(7, "Laptop", 52000, Category.ELECTRONICS));

                  inv.display();
                  inv.remove(6);

                  inv.display();
            } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
            }
      }
}
