class BankAccount{
      private double balance = 10000;

      public synchronized void withdraw(double amount){
            if(amount > balance){
                  System.out.println("Insufficient balance, waiting for deposit...");
                  try {
                        wait();
                  } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                  }
            }
            System.out.println("Withdrawing money...");
            balance -= amount;
            System.out.printf("Withdrew Rs.%.2f\nTotal balance: %.2f\n", amount, balance);
      }

      public synchronized void deposit(double amount){
            System.out.println("Depositing...");
            balance += amount;
            System.out.printf("Rs.%.2f deposited\nTotal balance: %.2f\n", amount, balance);
            notify();
      }
}

public class ThreadCommunication {
      public static void main(String[] args) {
            BankAccount acc = new BankAccount();

            new Thread(){
                  @Override
                  public void run(){
                        acc.withdraw(12000);
                  }
            }.start();
            new Thread(){
                  @Override
                  public void run(){
                        acc.deposit(6000);
                  }
            }.start();
      }
}
