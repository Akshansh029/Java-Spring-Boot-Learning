package practice;
/*
Problem Statement:
Create:
- Product → id, name, price
- CartItem → Product, quantity
- ShoppingCart:
      - Add item
      - Remove item
      - Calculate total price

Bonus:
- Apply discount if total > ₹5000
 */

class Product{
      private int id;
      private String name;
      private double price;

      public Product(int i, String n, double p){
            if(i < 1){
                  throw new IllegalArgumentException("ID must be a natural number");
            }
            if(n.isEmpty()){
                  throw new IllegalArgumentException("Product name cannot be empty");
            }
            if(p < 0){
                  throw new IllegalArgumentException("Price cannot be negative");
            }
            this.id = i;
            this.name = n;
            this.price = p;
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
}

class CartItem{
      private Product product;
      private int quantity;

      public CartItem(Product p, int q) {
            if(p == null){
                  throw new IllegalArgumentException("Product cannot be null");
            }
            if(q <= 0){
                  throw new IllegalArgumentException("Product quantity cannot be zero or negative");
            }
            this.product = p;
            this.quantity = q;
      }

      public Product getProduct() {
            return product;
      }

      public int getQuantity() {
            return quantity;
      }
}

// Not done by myself, took help
class ShoppingCart {
      private CartItem[] items;
      private int itemCount;
  
      public ShoppingCart(int capacity) {
          if (capacity <= 0) {
              throw new IllegalArgumentException("Cart capacity must be greater than zero");
          }
          items = new CartItem[capacity];
          itemCount = 0;
      }
  
      public void addItem(Product product, int quantity) {
          // Check if product already exists
          for (int i = 0; i < itemCount; i++) {
              if (items[i].getProduct().getId() == product.getId()) {
                  int newQty = items[i].getQuantity() + quantity;
                  items[i] = new CartItem(product, newQty);
                  return;
              }
          }
  
          if (itemCount >= items.length) {
              throw new IllegalStateException("Shopping cart is full");
          }
  
          items[itemCount++] = new CartItem(product, quantity);
      }
  
      public void removeItem(int productId) {
          for (int i = 0; i < itemCount; i++) {
              if (items[i].getProduct().getId() == productId) {
                  for (int j = i; j < itemCount - 1; j++) {
                      items[j] = items[j + 1];
                  }
                  items[--itemCount] = null;
                  return;
              }
          }
          throw new IllegalArgumentException("Product not found in cart");
      }
  
      public double calculateTotal() {
          double total = 0;
          for (int i = 0; i < itemCount; i++) {
              total += items[i].getProduct().getPrice() * items[i].getQuantity();
          }
  
          // Bonus discount
          if (total > 5000) {
              total *= 0.9; // 10% discount
          }
  
          return total;
      }
  
      public void displayCart() {
          for (int i = 0; i < itemCount; i++) {
              CartItem item = items[i];
              System.out.printf(
                  "%s x %d = %.2f%n",
                  item.getProduct().getName(),
                  item.getQuantity(),
                  item.getProduct().getPrice() * item.getQuantity()
              );
          }
          System.out.printf("Total Amount: %.2f%n", calculateTotal());
      }
  }
  

public class OnlineShoppingCart {
      public static void main(String[] args) {
            Product p1 = new Product(1, "Laptop", 4500);
            Product p2 = new Product(2, "Mouse", 800);
            Product p3 = new Product(3, "Keyboard", 900);

            ShoppingCart cart = new ShoppingCart(5);

            cart.addItem(p1, 1);
            cart.addItem(p2, 2);
            cart.addItem(p3, 1);

            cart.displayCart();

            cart.removeItem(2);
            cart.displayCart();
      }
}
