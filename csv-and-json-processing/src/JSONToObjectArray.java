import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;

public class JSONToObjectArray {

    public static void main(String[] args) {

        Path jsonPath = Path.of("employee.json");

        try {

            ObjectMapper mapper = new ObjectMapper();

            Employee[] employees = mapper.readValue(jsonPath.toFile(), Employee[].class);

            for (Employee employee : employees) {
                System.out.println(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}