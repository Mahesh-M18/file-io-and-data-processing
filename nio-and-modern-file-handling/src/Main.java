import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {

        var name = "Mahesh";
        System.out.println(name);

        Path path = Path.of("files", "data.txt");

        try {

            Files.writeString(path, "Hello Mahesh\nLearning Java NIO");//overwrites the content

            System.out.println("Exists: " + Files.exists(path));
            String content = Files.readString(path);

            System.out.println("File Content:");
            System.out.println(content);

        } catch (IOException e) {

            System.out.println("File operation failed: " + e.getMessage());
        }

        //try-with-resources example

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {

            System.out.println("File error: " + e.getMessage());
        }
    }
}
