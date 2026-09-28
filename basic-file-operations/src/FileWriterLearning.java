import java.io.FileWriter;
import java.io.IOException;

public class FileWriterLearning {
    public static void main(String[] args) throws IOException {

        //FileWriter writer = new FileWriter("data.txt"); //it erases the previous data or overwrites it, opens the file in overwrite mode
        FileWriter writer = new FileWriter("data.txt", true);//appends the new data instead of overwriting the existing data.
        //by default the append mode will be in false state

        writer.write("\nHello Mahesh");
        writer.write("\nWelcome to Java");

        writer.close();
    }
}

/*
FileWriter is used to write character data to a file.

FileWriter(file) → replace old content
FileWriter(file, true) → keep old content + add new content


 */
