import java.io.Serializable;

public class SerializationLearning {
    public static void main(String[] args) {

    }
}

/*
class Employee implements Serializable{
    String name;
    int age;
    double salary;
}
*/


/*
Why do we need Serialization?
Suppose you have a Java class:
class Employee {
    String name;
    int age;
    double salary;
}
And you create an object:
Employee employee = new Employee();

employee.name = "Mahesh";
employee.age = 22;
employee.salary = 50000;
While the program is running, the object exists in memory (RAM).
Conceptually:
RAM
┌─────────────────────────┐
│ Employee object         │
│                         │
│ name   = "Mahesh"       │
│ age    = 22             │
│ salary = 50000          │
└─────────────────────────┘
But when the program terminates:
Program ends
     ↓
Object removed from memory
The object is gone.
What if you want to save it and use it again tomorrow?
That's where serialization comes in.

What is Serialization?
Serialization is the process of converting a Java object's state into a format that can be stored or transmitted.
For Java's built-in object serialization:
Java Object
     ↓
Serialization
     ↓
Byte Stream
     ↓
File
For example:
Employee object
       ↓
{name="Mahesh", age=22, salary=50000}
       ↓
Binary data
       ↓
employee.ser
Later, we can reverse the process:
employee.ser
     ↓
Binary data
     ↓
Deserialization
     ↓
Employee object

Serialization vs Deserialization
These two terms are extremely important.

Serialization
Object → File
More precisely:
Object → Byte Stream

Deserialization
File → Object
More precisely:
Byte Stream → Object

SERIALIZATION
Java Object
     ↓
  bytes
     ↓
  storage

DESERIALIZATION
storage
   ↓
 bytes
   ↓
Java Object

What is Object Persistence?
Persistence means that data survives after the program stops running.
Without persistence:
Program starts
     ↓
Object created
     ↓
Program ends
     ↓
Object disappears
With persistence:
Program starts
     ↓
Object created
     ↓
Object saved to file
     ↓
Program ends
     ↓
Object still exists in file
     ↓
Program starts again
     ↓
Object loaded from file
So:
Object persistence means storing an object's state so it can be restored later.
Serialization is one way to achieve object persistence.

To serialize a Java object using Java's built-in serialization mechanism, the class should implement:
Serializable

in
implements Serializable
There is no method to implement.
Why?
Because Serializable is a marker interface.
6. What is a Marker Interface?
A marker interface is an interface that doesn't contain methods but tells Java that a class has some special capability or property.
For example:
public class Employee implements Serializable {
}
This tells Java:
Objects of Employee are allowed to participate in Java's serialization mechanism.
Think of it like a label:
Employee
   ↓
implements Serializable
   ↓
"Java, this object can be serialized."

You don't need to write:
serialize()
or:
deserialize()
There are no such required methods.


| Class                | Purpose            |
| -------------------- | ------------------ |
| `ObjectOutputStream` | Write Java objects |
| `ObjectInputStream`  | Read Java objects  |
| `writeObject()`      | Serialize object   |
| `readObject()`       | Deserialize object |
OUTPUT → ObjectOutputStream → writeObject()
INPUT  → ObjectInputStream  → readObject()

Multiple Objects

You can serialize more than one object.

For example:

objectOutputStream.writeObject(employee1);
objectOutputStream.writeObject(employee2);
objectOutputStream.writeObject(employee3);

Then later:

Employee employee1 =
        (Employee) objectInputStream.readObject();

Employee employee2 =
        (Employee) objectInputStream.readObject();

Employee employee3 =
        (Employee) objectInputStream.readObject();

The objects are read in the same sequence in which they were written.


Serializing a Collection

You can also serialize collections if the contained objects are serializable.

For example:

List<Employee> employees = new ArrayList<>();

employees.add(employee1);
employees.add(employee2);
employees.add(employee3);

Then:

objectOutputStream.writeObject(employees);

Later:

List<Employee> employees =
        (List<Employee>) objectInputStream.readObject();

This can be useful for persistence of multiple objects.
 */


/*
Serialization vs Database

You might wonder:

Why not just use a database?

Serialization is useful for certain situations, but it's not a replacement for a database.

Serialization
Java Object
    ↓
.ser file

Good for:

simple object persistence
saving application state
Java-specific data
learning object persistence
temporary/local storage
Database
Application
    ↓
Database

Better suited for:

large amounts of structured data
querying
multiple users
concurrent access
long-term application data management

For your assignment, Java serialization is exactly what you need to learn.


Serialization vs JSON

You'll learn JSON in T-6-ST-4, so it's useful to understand the difference.

Java Serialization
Java Object
    ↓
Binary data
    ↓
.ser

Usually Java-specific.

JSON
Java Object
    ↓
JSON
    ↓
{
  "name": "Mahesh",
  "age": 22
}

Human-readable and commonly used for APIs and data exchange.


Important Security Point
Java's native deserialization has security risks when deserializing untrusted data.

For example, you should not blindly do:

new ObjectInputStream(untrustedInput).readObject();

with data received from an unknown source.

Why?

Java deserialization can reconstruct object graphs and may trigger behavior through classes involved in the process.
Historically, this has led to serious security vulnerabilities.

The practical rule is:
Don't deserialize untrusted serialized Java data.
 */