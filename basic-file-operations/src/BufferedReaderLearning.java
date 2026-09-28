import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderLearning {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

        String line;

        //readLine() - reads one complete line
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}

/*
BufferedReader is used to read text more efficiently.

BufferedReader is a class that reads text more efficiently and provides convenient methods such as:
readLine()

Why do we use BufferedReader with FileReader?
Think of it like this:
Without BufferedReader
File
 ↓
FileReader
 ↓
Read character
Read character
Read character
Read character
...
With BufferedReader
File
 ↓
FileReader
 ↓
BufferedReader
 ↓
Read a chunk of data into memory
 ↓
Give it to your program efficiently
BufferedReader maintains a buffer (temporary memory area).
Instead of repeatedly going to the file for every character, it reads a larger block of characters into memory and then supplies them to your program as needed.
So:
FileReader = reads characters from the file
BufferedReader = adds buffering + convenient methods like readLine()

| FileReader                          | BufferedReader               |
| ----------------------------------- | ---------------------------- |
| Reads characters                    | Reads buffered characters    |
| Can read one character at a time    | Can read a complete line     |
| `read()`                            | `read()` + `readLine()`      |
| Less convenient for text processing | Very convenient              |
| Can be used directly                | Usually wraps another Reader |

FileReader fr = new FileReader("data.txt");

BufferedReader br = new BufferedReader(new FileReader("data.txt"));
Here:
FileReader
   ↓
Reads from file

BufferedReader
   ↓
Improves reading efficiency
   ↓
Provides readLine()

 */