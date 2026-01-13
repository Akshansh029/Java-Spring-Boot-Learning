class Calculator{
      public int add(int a, int b){
            int res = a + b;
            return res;
      }
}

public class Class{
      public static void main(String[] args) {
            Calculator calc = new Calculator();

            int res = calc.add(5, 11);
            System.out.println(res);
      }
}