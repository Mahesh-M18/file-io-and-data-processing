import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Path csvPath = Path.of("employee.csv");

        Path jsonPath = Path.of("employee.json");

        List<Employee> employees = new ArrayList<>();

        try{
            List<String> lines = Files.readAllLines(csvPath);

            for (int i =1;i<lines.size();i++){
                String line = lines.get(i);

                String[] values = line.split(",");

                int id = Integer.parseInt(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String department = values[3];
                double salary = Double.parseDouble(values[4]);

                Employee employee = new Employee(id,name,age,department,salary);

                employees.add(employee);
            }

            ObjectMapper mapper = new ObjectMapper();

            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonPath.toFile(), employees);

            System.out.println("CSV successfully converted to JSON.");



        } catch (IOException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}

//this program is executed in maven because it has jackson dependency which helps to write objects in json file
//executed in csv-to-json module