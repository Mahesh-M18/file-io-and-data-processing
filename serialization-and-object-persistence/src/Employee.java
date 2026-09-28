import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private int age;
    transient private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}

/*
class Employee implements Serializable {

    String name;
    int age;
    double salary;
}

All these fields are serializable:

name
age
salary

The object's state can be stored.

But what if the class contains another object?

class Employee implements Serializable {

    String name;
    Address address;
}

If Address doesn't implement Serializable, serialization can fail.

For example:

Employee employee = new Employee(
        "Mahesh",
        new Address(...)
);

If Address is not serializable, you can get:
NotSerializableException

Objects reachable through the object being serialized generally need to be serializable too,
unless they're excluded from serialization.

transient

Now suppose you have:
class Employee implements Serializable {

    String name;
    double salary;
    String password;
}

Maybe you don't want the password saved.

You can use:
transient

Example:
class Employee implements Serializable {

    String name;
    double salary;
    transient String password;
}

Now:
name     → serialized
salary   → serialized
password → NOT serialized

This is called a transient field.

What Happens to a Transient Field?

Suppose:
Employee employee = new Employee("Mahesh", 50000, "secret123");

After serialization and deserialization:
name     = Mahesh
salary   = 50000
password = null

For an instance reference field, the default after deserialization is generally null.

For primitives, default values apply:
int     → 0
double  → 0.0
boolean → false

So:
transient String password;
prevents the password from being serialized.
 */