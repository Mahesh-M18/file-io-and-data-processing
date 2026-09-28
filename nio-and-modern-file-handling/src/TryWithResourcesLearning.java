import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TryWithResourcesLearning {
    public static void main(String[] args) {

        Path path = Path.of("data.txt");
        Path path1 = Path.of("files/output.txt");
        try (BufferedReader reader = Files.newBufferedReader(path);
        BufferedWriter writer = Files.newBufferedWriter(path1))
        {

            String line;

            while ((line= reader.readLine())!=null){
                System.out.println(line);
            }

            writer.write("Hello Mahesh");
            writer.newLine();
            writer.write("Learning try with resources");
            writer.flush(); //moves the buffered content to the path

            System.out.println(Files.readString(path1));

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

/*
BufferedReader reader = ...;

// use reader

reader.close();
The problem is:
What if something goes wrong before close()?
For example:
BufferedReader reader =
        new BufferedReader(new FileReader("data.txt"));

String line = reader.readLine();

// some exception happens here

reader.close();
The close() statement may never execute.
That can cause a resource leak.


Try-with-resources Solution
Java provides:
try (...) {

}
for automatic resource management.
Example:
try (BufferedReader reader =
             new BufferedReader(new FileReader("data.txt"))) {

    String line;

    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }

} catch (IOException e) {
    System.out.println("File error: " + e.getMessage());
}
Notice:
try (BufferedReader reader = ...)
instead of:
try {
    BufferedReader reader = ...
}
Java automatically closes the resource when the try block finishes.

How Try-with-resources Works
Think of it like:
Open resource
     ↓
Execute try block
     ↓
Exception?
  ↙       ↘
Yes       No
 ↓         ↓
Handle    Continue
  ↘       ↙
    Close resource
         ↓
       Finish
The important part:
Java automatically calls close() for resources declared inside the try-with-resources statement.

NIO can create a BufferedReader for you:
BufferedReader reader =
        Files.newBufferedReader(path);
Instead of:
BufferedReader reader =
        new BufferedReader(
                new FileReader(path.toFile())
        );
The NIO version is cleaner:
Files.newBufferedReader(path);

Files.newBufferedWriter()
Similarly:
BufferedWriter writer =
        Files.newBufferedWriter(path);

write() → puts data into buffer
flush() → sends buffer data to file
close() → flushes + closes the writer
So whenever you want to write and then immediately read the same file while the writer is still open, use:
writer.flush();


| Operation           | Old approach          | NIO approach              |
| ------------------- | --------------------- | ------------------------- |
| Represent path      | `File`                | `Path`                    |
| Check existence     | `file.exists()`       | `Files.exists(path)`      |
| Read entire file    | `FileReader` etc.     | `Files.readString()`      |
| Read lines          | `BufferedReader`      | `Files.readAllLines()`    |
| Write text          | `FileWriter`          | `Files.writeString()`     |
| Copy                | streams / manual code | `Files.copy()`            |
| Move                | manual approach       | `Files.move()`            |
| Delete              | `file.delete()`       | `Files.delete()`          |
| Create directory    | `mkdir()`             | `Files.createDirectory()` |
| Resource management | manually close        | try-with-resources        |

Path  = WHERE
Files = DO

Which Resources Can Be Used?
Try-with-resources works with objects implementing:
AutoCloseable
For example, BufferedReader implements Closeable, which extends AutoCloseable.
So Java knows that it has a:
close()
operation it can automatically call.

A resource used in try-with-resources must implement AutoCloseable.

if an exception occurs inside the try block:
Exception
   ↓
try block stops
   ↓
resource automatically closed
   ↓
catch executes
That's the major advantage.

NIO
│
├── Path
│    └── Represents file/directory location
│
├── Files
│    ├── exists()
│    ├── createFile()
│    ├── createDirectory()
│    ├── createDirectories()
│    ├── readString()
│    ├── readAllLines()
│    ├── writeString()
│    ├── write()
│    ├── copy()
│    ├── move()
│    ├── delete()
│    ├── isRegularFile()
│    └── isDirectory()
│
└── Try-with-resources
     └── Automatically closes resources
 */
