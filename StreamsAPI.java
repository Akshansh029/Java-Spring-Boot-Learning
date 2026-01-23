
import java.util.Arrays;
import java.util.List;

public class StreamsAPI {
      public static void main(String[] args) {
            List<Integer> list = Arrays.asList(4,5,8,1,2,9,3,6);

            // Print even numbers
            // list.stream().filter(n -> n%2 == 0).forEach(n -> System.out.println(n));
            
            // Gives size of stream
            // System.out.println(list.stream().count());

            // Sum of all even numbers
            // int result = list.stream()
            //                   .filter(n -> n%2 == 0)
            //                   .map(n -> n*2)
            //                   .reduce(0, (c,e) -> c+e);
            // System.out.println(result);

            // Random example from Brave
            //       List<String> l = Stream.of("one", "two", "three", "four", "seventeen")
            //    .filter(e -> e.length() > 3)
            //    .peek(e -> System.out.println("Filtered value: " + e))
            //    .map(String::toUpperCase)
            //    .peek(e -> System.out.println("Mapped value: " + e))
            //    .collect(Collectors.toList());
            //    System.out.println(l);


            // Product of all even numbers
            int result = list.stream()
                              .filter(n -> n%2 == 0)
                              .map(n -> n*2)
                              .reduce(1, (c,e) -> c*e);
            System.out.println(result);
      }
}
