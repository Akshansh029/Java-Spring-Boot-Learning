
import java.util.Arrays;
import java.util.List;

public class MethodReference {
      public static void main(String[] args) {
            List<String> names = Arrays.asList("Akshansh", "Messi", "Max", "Sachin", "Virat");

            List<String> uNames = names.stream()
                                          .map(String::toUpperCase)
                                          .toList();

            uNames.forEach(System.out::println);
      }
}
