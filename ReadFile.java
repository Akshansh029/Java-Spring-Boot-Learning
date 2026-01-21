import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
      public static void main(String[] args) {
            File myObj = new File("filename.txt");

            try (Scanner sc = new Scanner(myObj)) {
                  while(sc.hasNextLine()){
                        String data = sc.nextLine();
                        System.out.println(data);
                  }
            } catch (FileNotFoundException e) {
                  System.out.println("An error occured");
            }
      }
}
