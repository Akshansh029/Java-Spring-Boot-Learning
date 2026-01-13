import practice.BankAccount;

public class Main {
      public static void main(String[] args) {
            BankAccount acc1 = new BankAccount("axis029", "Akshansh Singh", 12000);

            // acc1.getAccountHolderName();
            acc1.deposit(3700);
            // acc1.getBalance();
            acc1.withdraw(15000);
      }
}
