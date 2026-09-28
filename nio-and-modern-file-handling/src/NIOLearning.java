import java.nio.file.Path;

public class NIOLearning {
    public static void main(String[] args) {

        Path path = Path.of("data.txt");

        System.out.println(path);

        //getFileName() - gives the file name
        System.out.println(path.getFileName());

        //getParent() - Returns the parent path of the current path, or null if the path has no parent.
        System.out.println(path.getParent());

        //toAbsoultePath() - gives the absolute path
        System.out.println(path.toAbsolutePath());

        //getRoot() - Returns the root component of the path, or null if the path has no root.
        System.out.println(path.getRoot());



        Path path1 = Path.of("/Users/maheshm/Desktop/Learning/Bharat Sir's Training/Task6/file-io-and-data-processing/nio-and-modern-file-handling/src/data.txt");

        System.out.println("Original: " + path1);

        System.out.println("File Name: " + path1.getFileName());
        System.out.println("Parent: " + path1.getParent());
        System.out.println("Absolute: " + path1.toAbsolutePath());
        System.out.println("Root: " + path1.getRoot());
    }
}


/*
NIO = New I/O
Java NIO was introduced to provide a more modern and flexible way of working with files and other I/O operations.
The main classes you'll use here are:
java.nio.file.Path
java.nio.file.Paths
java.nio.file.Files
The most important change is:
Old approach
File file = new File("data.txt");
Modern approach
Path path = Path.of("data.txt");

Then instead of using many different classes for operations, you can use:
Files.readString(path);
Files.writeString(path, "Hello");
Files.exists(path);
Files.delete(path);
So the basic idea is:
Old Java I/O
    ↓
File + FileReader + FileWriter + BufferedReader...

Modern Java NIO
    ↓
Path + Files
 */

/*
Path
Path represents the location/path of a file or directory.
Import:
import java.nio.file.Path;
Example:
Path path = Path.of("data.txt");
Think of it like:
Path
 ↓
"Where is my file?"
It doesn't mean that the file necessarily exists.
For example:
Path path = Path.of("abc.txt");
You have created a Path object representing:
abc.txt
But this does not create abc.txt on your computer.

Creating a Path

The modern recommended approach is:
Path path = Path.of("data.txt");

You can also specify directories:
Path path = Path.of("files", "data.txt");
This represents:
files/
└── data.txt

You can also use an absolute path:
Path path = Path.of("C:\\Users\\Mahesh\\Documents\\data.txt");

 */

/*
Relative path
Path path = Path.of("data.txt");
Means:
“data.txt is located relative to my current working directory.”
It does not contain the complete location.
data.txt
  ↑
Relative location
So:
path.getParent(); // null
path.getRoot();   // null

Absolute path
Path path = Path.of(
    "/Users/maheshm/Desktop/..../nio-and-modern-file-handling/src/data.txt"
);
Means:
“This is the exact location of the file on the computer.”
It starts from the root:
/
└── Users
    └── maheshm
        └── Desktop
            └── ...
                └── data.txt
Therefore:
path.getParent(); // .../src
path.getRoot();   // /

|                               | Relative                   | Absolute                        |
| ----------------------------- | -------------------------- | ------------------------------- |
| Example                       | `"data.txt"`               | `"/Users/maheshm/.../data.txt"` |
| Full location?                | ❌ No                       | ✅ Yes                           |
| Depends on current directory? | ✅ Yes                      | ❌ No                            |
| Root                          | `null`                     | `/`                             |
| Parent                        | `null` for just `data.txt` | `/Users/.../src`                |

Relative → "Go to data.txt from here"
Absolute → "Go to this exact address"
 */

/*
Path Does Not Perform File Operations
This distinction is important.
If you write:
Path path = Path.of("data.txt");
you have only described the location.
You haven't:
created the file
read the file
written to the file
deleted the file
For those operations, we use:
Files
 */