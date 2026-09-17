import java.io.File;
import java.io.IOException;

public class FileLearning {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test.txt");
        //exists() - returns true or false for file existence
        System.out.println(file1.exists());

        File file2 = new File("data.txt");

        //createNewFile() - creates new file
        if (file2.createNewFile()) { //createNewFile() can throw IOException
            System.out.println("data.txt file created");
        }

        //getName() - returns name of the file
        System.out.println(file2.getName());

        //getAbsolutePath() - returns the complete path
        System.out.println(file2.getAbsolutePath());

        //isFile() - checks whether the path represents a file
        System.out.println(file2.isFile());

        //isDirectory() - checks whether the path represents a directory
        System.out.println(file2.isDirectory());
    }
}

/*
Input → getting data from somewhere
Output → sending/storing data somewhere

When working with files:
Your Java Program
      ↓
   File on Disk
Reading
Your program takes data from a file.
data.txt
   ↓
Java Program
Writing
Your program puts data into a file.
Java Program
   ↓
data.txt
For example, suppose students.txt contains:
Mahesh
Rahul
Anil
Java can read this file and display:
Mahesh
Rahul
Anil
Or Java can create a file:
students.txt
and write:
Mahesh
Rahul
Anil


 */