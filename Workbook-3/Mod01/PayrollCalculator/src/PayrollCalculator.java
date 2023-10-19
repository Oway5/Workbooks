import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        String line;
        String path = "employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // Skip first row
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int employeeId = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                double hoursWorked = Double.parseDouble(tokens[2].trim());
                double payRate = Double.parseDouble(tokens[3].trim());
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                System.out.println(employee);
                //System.out.printf("Employee ID: %d, Name: %s, Gross Pay: %.2f%n",
                        //employee.getEmployeeId(),employee.getName(),employee.getGrossPay());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
