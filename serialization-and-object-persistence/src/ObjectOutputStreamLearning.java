import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class ObjectOutputStreamLearning {
    public static void main(String[] args) {

        Employee employee = new Employee("Mahesh", 22, 45000);

        try (FileOutputStream fileOutputStream = new FileOutputStream("employee.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(employee);
            System.out.println("Object serialized successfully.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
ObjectOutputStream
Package:
java.io.ObjectOutputStream
Its purpose is:
Convert Java objects into a byte stream and write them to an output stream.
Conceptually:
Java Object
     ↓
ObjectOutputStream
     ↓
Bytes
     ↓
File


Conceptually:

Program
   ↓
FileOutputStream
   ↓
employee.ser

But FileOutputStream doesn't understand Java objects.

That's why we put:

Object
 ↓
ObjectOutputStream
 ↓
FileOutputStream
 ↓
File

Why are streams nested?

ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

It means:

Object
  ↓
ObjectOutputStream
  ↓
FileOutputStream
  ↓
File

ObjectOutputStream knows how to convert Java objects into bytes.
FileOutputStream knows how to write bytes to a file.

Together:

Object
 ↓
ObjectOutputStream
 ↓
bytes
 ↓
FileOutputStream
 ↓
employee.ser

writeObject()
This is the key method:

objectOutputStream.writeObject(employee);

It means:
Serialize this object and write it to the output stream.

So:
Employee employee = ...

becomes:
employee
   ↓
writeObject()
   ↓
serialized byte data
   ↓
employee.ser

What Does the .ser File Contain?

Instead, Java's serialization format stores binary data.
The .ser extension is a common convention, not a requirement.
 */