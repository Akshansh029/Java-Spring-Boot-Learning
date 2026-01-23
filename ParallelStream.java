
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
      public static void main(String[] args) {
            Random ran = new Random();

            int size = 10_000;
            List<Integer> nums = new ArrayList<>(size);

            for (int i = 1; i <= size; i++) {
                  nums.add(ran.nextInt(100));
            }

            long startSeq = System.currentTimeMillis();
            int sum1 = nums.stream()
            .mapToInt(n -> n*2)
            .sum();
            long endSeq = System.currentTimeMillis();
            
            long startPara = System.currentTimeMillis();
            int sum2 = nums.parallelStream()
            .mapToInt(n -> n*2)
            .sum();
            long endPara = System.currentTimeMillis();

            System.out.println("Seq: " + sum1 + ", time: " + (endSeq-startSeq));
            System.out.println("Para: " + sum2 + ", time: " + (endPara-startPara));
      }      
}
