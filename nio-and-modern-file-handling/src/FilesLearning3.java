import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class FilesLearning3 {
    public static void main(String[] args) {

        Path directory = Path.of("files");

        try (var stream = Files.list(directory)){
            stream.forEach(System.out::println);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

/*
In Java, var is a special identifier used for local variable type inference, which allows the compiler to automatically
figure out the data type of a variable based on the value assigned to it.

var stream = Files.list(directory)
var allows Java to automatically determine the type.
The actual type returned by Files.list() is:
Stream<Path>
So this:
var stream
is essentially:
Stream<Path> stream

files/
├── data.txt
├── output.txt
└── backup/
The stream contains:
data.txt
output.txt
backup/
Important: Files.list() lists only the direct contents. It does not automatically go inside backup/.

try (...)?
try (var stream = Files.list(directory)) {
This is called try-with-resources.
The stream uses system resources, so we should close it after we're finished.
Java automatically does:
Open stream
    ↓
Use stream
    ↓
Close stream automatically
You don't need:
stream.close();
That's one of the main reasons to use try-with-resources.

These two are equivalent:
stream.forEach(System.out::println);
and
stream.forEach(path -> System.out.println(path));
System.out::println is a method reference.

Files.list() gives you a stream of the files and folders directly inside a directory, forEach() processes each one,
and try-with-resources automatically closes the stream.


stream() → creates a stream
filter() → selects the required data
forEach() → performs an action on each result
 */