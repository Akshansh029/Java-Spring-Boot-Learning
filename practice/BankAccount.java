package practice;
/*
Create a BankAccount class with:
- accountNumber (String)
- accountHolderName (String)
- balance (double)

Requirements:
- Balance should never be negative

Methods:
- deposit(double amount)
- withdraw(double amount)
- getBalance()

Edge Cases to Handle:
- Withdraw more than balance
- Deposit negative amount
 */

public class BankAccount {
      private final String accountNumber;
      private String accountHolderName;
      private double balance;

      public BankAccount(String accNum,
      String accHolderName,
      double bal){
            accountNumber = accNum;
            accountHolderName = accHolderName;
            balance = bal;
      }

      public void deposit(double amount){
            if(amount <= 0){
                  System.out.println("Depositing amount should be atleast Rs 1");
            } else{
                  System.out.printf("Depositing Rs.%.2f into account...\n", amount);
                  balance += amount;
                  System.out.printf("Amount Rs.%.2f deposited into your account, total balance: Rs.%.2f\n", amount, balance);
            }
      }

      public double withdraw(double amount){
            if(amount > 0){
                  if(amount > balance){
                        System.out.printf("Cannot withdraw amount more than the balance, current balance is Rs.%.2f\n", balance);
                  } else{
                        balance -= amount;
                        System.out.printf("Withdrew Rs.%.2f, current balance is Rs.%.2f\n", amount, balance);
                        return amount;
                  }
            } else{
                  System.out.println("Cannot withdraw negative amount");
            }
            return 0;
      }

      public double getBalance(){
            System.out.printf("Your current bank balance is Rs.%.2f\n", balance);
            return balance;
      }

      public String getAccountHolderName(){
            System.out.printf("Current account holder name is %s\n", accountHolderName);
            return accountHolderName;
      }
}
