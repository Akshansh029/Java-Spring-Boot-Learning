public class EnumExample {
      public enum Day{
            Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
      }

      public static void main(String[] args) {
            Day yesterday = Day.Sunday;
            Day today = Day.Monday;
            Day tomorrow = Day.Tuesday;

            System.out.println("Yesterday was " + yesterday);
            System.out.println("Today is " + today);
            System.out.println("Tomorrow will be " + tomorrow);
      }
}
