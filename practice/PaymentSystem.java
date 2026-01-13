package practice;

/*
Create an interface PaymentMethod:
- void pay(double amount);

Implement:
- CreditCardPayment
- UPIPayment
- CashPayment

Driver Class:
- Accept a PaymentMethod reference
- Call pay() dynamically
 */

interface PaymentMethod{
      void pay(double amount);
}

class CreditCardPayment implements PaymentMethod{
      @Override
      public void pay(double amount){
            if(amount <= 0){
                  throw new IllegalArgumentException("Least payable amount is Rs.1");
            }
            System.out.printf("Paying Rs.%.2f through credit card\n", amount);
      }
}
class UPIPayment implements PaymentMethod{
      @Override
      public void pay(double amount){
            if(amount <= 0){
                  throw new IllegalArgumentException("Least payable amount is Rs.1");
            }
            System.out.printf("Paying Rs.%.2f through UPI\n", amount);
      }
}
class CashPayment implements PaymentMethod{
      @Override
      public void pay(double amount){
            if(amount <= 0){
                  throw new IllegalArgumentException("Least payable amount is Rs.1");
            }
            System.out.printf("Paying Rs.%.2f through cash\n", amount);
      }
}

public class PaymentSystem {
      public static void main(String[] args) {
            // Version 1

            // try {
            //       PaymentMethod pay1 = new CreditCardPayment();
            //       PaymentMethod pay2 = new UPIPayment();
            //       PaymentMethod pay3 = new CashPayment();
            //       pay1.pay(-2000);
            //       pay2.pay(3000);
            //       pay3.pay(4000);
            // } catch (Exception e) {
            //       System.out.println(e.getMessage());
            // }

            // Version 2 (Version 1 stops execution of other payments, this one does not)
            PaymentMethod[] methods = {
                  new CreditCardPayment(),
                  new UPIPayment(),
                  new CashPayment()
              };
              
              double[] amounts = { -2000, 3000, 4000 };
              
              for (int i = 0; i < methods.length; i++) {
                  try {
                      methods[i].pay(amounts[i]);
                  } catch (IllegalArgumentException e) {
                      System.out.println(e.getMessage());
                  }
              }
              
      }
}
