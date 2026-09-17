import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterLearning {
    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));

        writer.newLine();
        writer.write("File I/O Learning");
        writer.newLine();
        writer.write("Writing data to File");

        writer.close();
    }
}


/*
Just like BufferedReader improves reading, BufferedWriter provides buffered writing.
Package:
java.io.BufferedWriter
Structure:
Program
   ↓
BufferedWriter
   ↓
FileWriter
   ↓
File

newLine()
Instead of:
writer.write("\n");
you can use:
writer.newLine();
Example:
writer.write("Line 1");
writer.newLine();
writer.write("Line 2");
Output:
Line 1
Line 2
newLine() is preferable because it uses the appropriate line separator for the operating system.

Why use BufferedReader with FileReader?
You might wonder:
Why do we need both?
Because they have different responsibilities.
new BufferedReader(new FileReader("data.txt"))
Think of it as:
FileReader
    ↓
Connects to the file and reads characters

BufferedReader
    ↓
Provides efficient buffered reading
and convenient readLine()
Similarly:
new BufferedWriter(new FileWriter("data.txt"))
means:
FileWriter
    ↓
Writes characters to the file

BufferedWriter
    ↓
Provides buffered writing
and newLine()

| `FileWriter`                         | `BufferedWriter`               |
| ------------------------------------ | ------------------------------ |
| Writes characters directly to a file | Writes through a buffer        |
| Simpler                              | More efficient for many writes |
| Can write strings/characters         | Can write strings/characters   |
| `write()`                            | `write()` + `newLine()`        |
| Can be used directly                 | Usually wraps a `Writer`       |


BufferedWriter temporarily stores data in a buffer and writes it to the file in larger chunks, reducing direct file operations.
Easy to remember
FileWriter = writes to the file
BufferedWriter = makes writing more efficient + provides newLine()
For larger amounts of text, BufferedWriter is generally preferred.

 */


/*
| Class            | Purpose                   |
| ---------------- | ------------------------- |
| `FileReader`     | Read characters from file |
| `FileWriter`     | Write characters to file  |
| `BufferedReader` | Efficiently read text     |
| `BufferedWriter` | Efficiently write text    |


keeping files/resources open unnecessarily can cause:
resource leaks
file access problems
too many open files
data not being flushed properly
So the basic rule is:
Open
 ↓
Use
 ↓
Close


try-catch with File Operations
File operations can throw IOException.
Example:
try {
    FileReader reader = new FileReader("data.txt");

    // read file

    reader.close();

} catch (IOException e) {
    System.out.println("File error: " + e.getMessage());
}
But there is a problem here.
If an exception occurs before:
reader.close();
the reader might not get closed.

File resources should always be properly closed.
 */