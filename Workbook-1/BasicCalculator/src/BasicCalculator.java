import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        float num1 = scanner.nextFloat();

        System.out.print("Enter the second number: ");
        float num2 = scanner.nextFloat();

        System.out.println("Possible calculations:");
        System.out.println(" (A)dd");
        System.out.println(" (S)ubtract");
        System.out.println(" (M)ultiply");
        System.out.println(" (D)ivide");
        System.out.print("Please select an option: ");
        char choice = scanner.next().charAt(0);

        if (Character.toUpperCase(choice) == 'A') {
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        } else if (Character.toUpperCase(choice) == 'S') {
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        } else if (Character.toUpperCase(choice) == 'M') {
            System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        } else if (Character.toUpperCase(choice) == 'D') {
            if (num2 != 0) {
                System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
            } else {
                System.out.println("Error: Division by zero.");
            }
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
