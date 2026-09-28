public class JSONLearning {
    public static void main(String[] args) {

    }
}

/*
JSON = JavaScript Object Notation

Despite its name, JSON is not limited to JavaScript.

It is a widely used text format for representing structured data.

Example:

{
  "name": "Mahesh",
  "age": 22,
  "department": "IT"
}

Compare this with CSV:

Mahesh,22,IT

JSON is more descriptive because the field names are included.

JSON Object

A JSON object is enclosed in:
{ }

Example:
{
  "name": "Mahesh",
  "age": 22
}

It contains key-value pairs:
"name" → "Mahesh"
"age"  → 22

Think:
{
    key   : value
}

JSON Data Types

JSON supports several common data types.

String
"name": "Mahesh"
Number
"age": 22
Boolean
"active": true
Null
"manager": null
Array
"skills": ["Java", "Python", "SQL"]
Object
"address": {
    "city": "Bangalore",
    "country": "India"
}

JSON Array

Multiple employees can be represented using a JSON array.

An array uses:
[ ]

Example:
[
  {
    "name": "Mahesh",
    "age": 22,
    "department": "IT"
  },
  {
    "name": "Rahul",
    "age": 23,
    "department": "HR"
  }
]

Think:

JSON Array
│
├── Employee Object
│
└── Employee Object

| CSV                          | JSON                        |
| ---------------------------- | --------------------------- |
| Tabular                      | Hierarchical/structured     |
| Usually comma-separated      | Uses objects/arrays         |
| Compact for simple tables    | More descriptive            |
| Easy to open in spreadsheets | Common in APIs              |
| Limited data structure       | Supports nested objects     |
| Good for rows/columns        | Good for complex structures |


 */
