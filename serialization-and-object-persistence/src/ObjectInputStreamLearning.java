import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class ObjectInputStreamLearning {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("employee.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Employee employee = (Employee) objectInputStream.readObject();
            employee.display();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
ObjectInputStream

Now we know how to save an object.

But how do we get it back?

Use:

ObjectInputStream

Package:

java.io.ObjectInputStream

Its job is:

Read serialized bytes and reconstruct the Java object.

Conceptually:

File
 ↓
FileInputStream
 ↓
ObjectInputStream
 ↓
Java Object
 */


/*
              SERIALIZATION

       Java Object
            │
            ↓
    ObjectOutputStream
            │
            ↓
      FileOutputStream
            │
            ↓
       employee.ser

And:

             DESERIALIZATION

       employee.ser
            │
            ↓
     FileInputStream
            │
            ↓
     ObjectInputStream
            │
            ↓
       Java Object
 */

/*
Why Use try-with-resources Here?

Serialization involves resources:

FileOutputStream
ObjectOutputStream

So instead of:

ObjectOutputStream output = ...;

// use output

output.close();

we use:

try (ObjectOutputStream output = ...) {

    output.writeObject(employee);

}

Java automatically closes it.

The same applies to deserialization.
 */