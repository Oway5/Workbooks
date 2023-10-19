import java.io.*;
import java.util.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the employee file: ");
        String inputName = scanner.nextLine() +".csv";
        System.out.print("Enter the name of the payroll file to create: ");
        String outputName = scanner.nextLine()+".csv";


        //String path = "employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(inputName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputName))) {
                br.readLine(); // Skip first row
                bw.write("id|name|gross pay\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int employeeId = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                double hoursWorked = Double.parseDouble(tokens[2].trim());
                double payRate = Double.parseDouble(tokens[3].trim());
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                bw.write(String.format("%d|%s|%.2f%n", employee.getEmployeeId(),employee.getName(),employee.getGrossPay()));
                //System.out.println(employee);
                //System.out.printf("Employee ID: %d, Name: %s, Gross Pay: %.2f%n",
                        //employee.getEmployeeId(),employee.getName(),employee.getGrossPay());
            }
        } catch (IOException e) {
           // System.out.print("got caught");
            e.printStackTrace();
           // System.out.print("got caught");
        }
        //System.out.print("got caught");
    }
}
