import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogAnalyzer {
    public static void main(String[] args) {

        int errorCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("files/application.log"));

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("ERROR")) {
                    errorCount++;
                }
            }

            reader.close();

            System.out.println("Total ERROR occurrences: " + errorCount);

        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }
    }
}
