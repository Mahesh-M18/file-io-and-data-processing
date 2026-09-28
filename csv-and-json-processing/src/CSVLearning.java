import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSVLearning {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("employee.csv");

        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            System.out.println(line);
        }

    }
}

/*
CSV = Comma-Separated Values

It is a simple text-based format where values are separated by commas.

Example:

name,age,department,salary
Mahesh,22,IT,50000
Rahul,23,HR,45000
Anil,24,Finance,60000

Each line represents a record.

Each comma separates fields.

Think of it like a table:

name	age	department	salary
Mahesh	22	IT	50000
Rahul	23	HR	45000
Anil	24	Finance	60000


CSV Header

The first line is commonly the header.
name,age,department,salary

It tells us what each column represents.

Then:

Suresh,22,IT,50000

means:

name       → Suresh
age        → 22
department → IT
salary     → 50000

CSV Records

Consider:
name,age,department,salary
Mahesh,22,IT,50000
Rahul,23,HR,45000
Anil,24,Finance,60000

There are:

Header
 ↓
name | age | department | salary

Records
 ↓
Mahesh | 22 | IT      | 50000
Rahul  | 23 | HR      | 45000
Anil   | 24 | Finance | 60000

So:

Header → describes columns
Record/row → represents one employee
Field/column → individual piece of information

Splitting a CSV Line

Suppose:

String line = "Mahesh,22,IT,50000";

You can use:

String[] values = line.split(",");

Now:

values[0] → Mahesh
values[1] → 22
values[2] → IT
values[3] → 50000

For example:

System.out.println(values[0]);
System.out.println(values[1]);
System.out.println(values[2]);
System.out.println(values[3]);

Output:

Mahesh
22
IT
50000

Important CSV Limitation

This is where CSV becomes slightly more complicated.
Consider:

Mahesh,22,Bangalore, Karnataka

If you simply do:

line.split(",");

you'll get:
Mahesh
22
Bangalore
 Karnataka

But perhaps:
Bangalore, Karnataka
was supposed to be one field.

CSV supports quoting:
Mahesh,22,"Bangalore, Karnataka"

Now the comma inside the quotes is part of the value.
 */
