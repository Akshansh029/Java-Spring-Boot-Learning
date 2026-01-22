package practice;
/*
Problem Statement
Create:
- InsufficientBalanceException
- InvalidAmountException

Rules:
- Deposit amount must be > 0
- Withdrawal must not exceed balance
- Handle all exceptions properly
*/

class InsufficientBalanceException extends Exception{
      public InsufficientBalanceException(String msg){
            super(msg);
      }
}
class InvalidAmountException extends Exception{
      public InvalidAmountException(String msg){
            super(msg);
      }
}

class BankAccount{
      private String accountHolderName;
      private double balance;

      public BankAccount(String holderName, double bal) throws InvalidAmountException{
            if(bal < 0){
                  throw new InvalidAmountException("Initial amount must be greater than zero");
            }
            if(holderName.isEmpty()){
                  throw new IllegalArgumentException("Account holder name cannot be empty");
            }
            this.accountHolderName = holderName;
            this.balance = bal;
      }

      public boolean deposit(double amount) throws InvalidAmountException{
            if(amount <= 0){
                  throw new InvalidAmountException("Depositing amount must be greater than zero");
            }
            balance += amount;
            return true; 
      }

      public boolean withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException{
            if(amount > balance){
                  throw new InsufficientBalanceException("Insufficient balance");
            }
            if (amount <= 0) {
                  throw new InvalidAmountException("Withdrawal amount must be greater than zero");
            }
            balance -= amount;
            return true; 
      }

      public String getAccountHolderName() {
            return accountHolderName;
      }

      public double getBalance() {
            return balance;
      }

      @Override
      public String toString() {
            return "BankAccount [accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
      }
}

public class TransactionProcessor {
      public static void main(String[] args) {
            try {
                  BankAccount acc = new BankAccount("Akshansh", 10000);
                  System.out.println("Account created successfully!");
                  System.out.println("Account details: " + acc.toString());

                  if(acc.deposit(2000)){
                        System.out.println("\nMoney deposited successfully");
                        System.out.println("Total balance: " + acc.getBalance());
                  }
                  if(acc.withdraw(14000)){
                        System.out.println("\nMoney withdrew successfully");
                        System.out.println("Total balance: " + acc.getBalance());
                  }
            } catch (InvalidAmountException | InsufficientBalanceException e) {
                  System.out.println(e.getMessage());
            }
      }
}
