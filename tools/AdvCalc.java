package tools;

public class AdvCalc extends Calc{
      public int mul(int n1, int n2){
            return n1 * n2;
      }
      public double div(int n1, int n2){
            if(n2 == 0){
                  System.out.println("Cannot divide by zero");
                  return 0;
            }
            double res = (double) n1/n2;
            return res;
      }  
}
