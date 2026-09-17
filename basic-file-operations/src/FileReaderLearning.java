import java.io.FileReader;
import java.io.IOException;

public class FileReaderLearning {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("data.txt");

        int ch;

        while ((ch = reader.read()) != -1) {
            System.out.println((char) ch);
        }
        reader.close();
    }
}

/*
FileReader reads characters from the file.

Why does read() return an int?

reader.read();
returns an int.
For example:
H → 72
e → 101
l → 108
So we convert it into a character:
(char) character
But there is another special value:
-1
-1 means:
End of file has been reached.
That's why we commonly write:
while ((character = reader.read()) != -1)
Meaning:
Read character
      ↓
Is it -1?
  ↙       ↘
Yes       No
 ↓         ↓
Stop     Process it

Problem with FileReader
Imagine a file contains 1 million characters.
This:
reader.read();
reads one character at a time.
That can be inefficient.
For this reason, Java provides:
BufferedReader
Also, if you want to process the file line by line, FileReader doesn't directly provide a readLine() method.
That's where BufferedReader helps.
 */

