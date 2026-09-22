import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;

public class FilesLearning {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("data.txt");

        System.out.println(Files.exists(path));
        System.out.println(Files.readString(path));
        Files.writeString(path,"\nHello",StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        //StandardOpenOption.CREATE - Creates the file if it doesn't exist.
        //StandardOpenOption.APPEND - Adds content to the end instead of replacing existing content.
        System.out.println(Files.readString(path));

        Path path1 = Path.of("info.txt");

        //exists(path) - checks if an file exists in the path
        System.out.println(Files.exists(path1));

        //createFile(path) - creates a file if it doesn't exist, if file already exists it throws an exception
        Files.createFile(path1);

        Path path2 = Path.of("files");

        //createDirectory(path) - creates a directory, gives exception if it already exists
        Files.createDirectory(path2);

        //createDirectories(path) - for creating nested directories
        // files/
        //   logs/
        //      application/
        Path path3 = Path.of("files","logs","application");
        Files.createDirectories(path3);

        String content = Files.readString(path);
        System.out.println(content);

        Files.writeString(path1,"Hello Mahesh\nWelcome to Java\nLearning NIO");

        List<String> lines = Files.readAllLines(path1);

        for (String line : lines) {
            System.out.println(line);
        }


    }
}

/*
Files is a utility class containing methods for performing operations on files and directories.

import java.nio.file.Files;
The relationship is:
Path
 ↓
Represents location

Files
 ↓
Performs operations on that location

For example:
Path path = Path.of("data.txt");

Files.exists(path);
Files.readString(path);
Files.writeString(path, "Hello");

| Method                 | Returns        | Use when                               |
| ---------------------- | -------------- | -------------------------------------- |
| `Files.readString()`   | `String`       | You want the entire file as one string |
| `Files.readAllLines()` | `List<String>` | You want individual lines              |


 */