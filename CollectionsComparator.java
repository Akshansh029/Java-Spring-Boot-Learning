import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsComparator {
      public static void main(String[] args) {
            List<String> list = new ArrayList<>();

            // Comparator<String> com = new Comparator<String>() {      // Comparator based on String length
            //       @Override
            //       public int compare(String s1, String s2){
            //             if(s1.length() > s2.length())
            //                   return 1;
            //             else
            //                   return -1;
            //       }
            // };

            // Used Lambda expression
            Comparator<String> com = (s1, s2) -> {
                  if(s1.length() > s2.length())
                        return 1;
                  else
                        return -1;
            };

            list.add("Messi");
            list.add("Pele");
            list.add("Maradona");
            list.add("Ronaldo");
            list.add("Zidane");

            Collections.sort(list, com);

            System.out.println(list);
      }      
}
