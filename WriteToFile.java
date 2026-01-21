import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
      public static void main(String[] args) {
            try (FileWriter writer = new FileWriter("filename.txt")){
                  writer.write("Files in Java might be tricky, but it is fun enough!");
                  System.out.println("Content written to file successfully");
            } catch (IOException e) {
                  System.out.println("An error occured");
            }
      }
}
