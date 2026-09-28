import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;


public class FilesLearning2{
    public static void main(String[] args) throws IOException {

        Path path = Path.of("info1.txt");

        Files.writeString(path, "\nWelcome"); //This creates the file if necessary and writes the text.

        System.out.println(Files.isRegularFile(path));

        System.out.println(Files.isDirectory(path));

        List<String> lines = List.of("Mahesh", "Rahul", "Anil");

        Files.write(path, lines);

        Path source = Path.of("source.txt");
        Path destination = Path.of("destination.txt");

        Files.copy(source,destination); //source.txt path should exist and destination path will be created

        Path source1 = Path.of("source.txt");
        Path destination1 = Path.of("source.txt");

        Files.move(source1,destination1); //renames the source.txt file to destination name

        if (Files.exists(path)){
            Files.delete(path);
        }

        Files.delete(destination1); //deletes the file but can cause exception if file doesn't exists
        Files.deleteIfExists(destination); //checks the existence of file and deletes it

    }
}

/*
Writing to a File
NIO also makes writing simple.
Path path = Path.of("data.txt");

Files.writeString(path, "Hello Mahesh");
This creates the file if necessary and writes the text.
The file will contain:
Hello Mahesh
14. Writing Multiple Lines
You can use:
List<String> lines = List.of(
        "Mahesh",
        "Rahul",
        "Anil"
);

Files.write(path, lines);
The file becomes:
Mahesh
Rahul
Anil


If you want to append:
Files.writeString(
        path,
        "\nNew content",
        StandardOpenOption.APPEND
);
Import:
import java.nio.file.StandardOpenOption;

Creating and Writing in One Step
You don't necessarily have to manually create the file first.
For example:
Path path = Path.of("data.txt");

Files.writeString(path, "Hello Java");
If data.txt doesn't exist, Java can create it.
So you can often simply do:
Path
 ↓
Files.writeString()
 ↓
File created/written


Copying a File
NIO also makes copying easy.
Path source.txt = Path.of("data.txt");
Path destination = Path.of("backup.txt");

Files.copy(source.txt, destination);
Now:
data.txt
   ↓
backup.txt
Both files contain the same data.


Moving/Renaming a File
You can move a file:
Path source.txt = Path.of("data.txt");
Path destination = Path.of("source.txt.txt");

Files.move(source.txt, destination);
This can also effectively rename:
data.txt
    ↓
source.txt.txt


Renaming
Your example:
Path source.txt = Path.of("data.txt");
Path destination = Path.of("source.txt.txt");

Files.move(source.txt, destination);
Both files are in the same directory:
Before:
folder/
├── data.txt
After:
folder/
├── source.txt.txt
The location doesn't change; only the name changes.
So this is effectively a rename.

Moving
If the destination is in another directory:
Path source.txt = Path.of("data.txt");
Path destination = Path.of("backup/data.txt");

Files.move(source.txt, destination);
Now:
Before:
folder/
├── data.txt
└── backup/
After:
folder/
└── backup/
    └── data.txt
The file's location changes.
So this is a move.
Easy way to remember
Same directory + different name
        ↓
     Rename

Different directory
        ↓
      Move
And in Java, both are performed using:
Files.move(source.txt, destination);
So Files.move() is the method, while rename vs. move describes what actually changes.

Deleting a File
Path path = Path.of("data.txt");

Files.delete(path);
The file is deleted.
You can check first:
if (Files.exists(path)) {
    Files.delete(path);
}
There is also:
Files.deleteIfExists(path);
This is useful when you don't want an exception just because the file doesn't exist.
 */