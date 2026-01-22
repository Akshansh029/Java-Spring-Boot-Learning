package practice;
/*
Problem Statement
- Create:
      - enum OrderStatus { NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED }

- Interface OrderService:
      - void updateStatus(OrderStatus newStatus);

- Class Order implementing OrderService

Rules
- Order cannot move backward (e.g., SHIPPED → PROCESSING)
- DELIVERED orders cannot be cancelled
- Throw a custom exception for invalid transitions

Task
- Demonstrate valid & invalid status updates
 */

enum OrderStatus {
      NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

interface OrderService {
      void updateStatus(OrderStatus newStatus) throws OrderStatusException;
}

class OrderStatusException extends Exception{
      public OrderStatusException(String msg){
            super(msg);
      }
}

class Order implements OrderService{
      private OrderStatus prevStatus = OrderStatus.NEW;

      @Override
      public void updateStatus(OrderStatus newStatus) throws OrderStatusException{
            if(newStatus.ordinal() < prevStatus.ordinal()){
                  throw new OrderStatusException("Order status cannot move backward");
            }
            if(prevStatus == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED){
                  throw new OrderStatusException("Delivered orders cannot be cancelled");
            }
            prevStatus = newStatus;
      }

      public OrderStatus getOrderStatus(){
            return prevStatus;
      }
}

public class OrderProcessing {
      public static void main(String[] args) {
            Order o = new Order();
            try {
                  o.updateStatus(OrderStatus.PROCESSING);
                  o.updateStatus(OrderStatus.SHIPPED);
                  o.updateStatus(OrderStatus.DELIVERED);
                  o.updateStatus(OrderStatus.CANCELLED);
            } catch (OrderStatusException e) {
                  System.out.println(e.getMessage());
            } finally{
                  System.out.println(o.getOrderStatus());
            }

      }
}
