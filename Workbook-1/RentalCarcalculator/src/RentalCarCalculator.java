import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pickup date (e.g. MM/DD/YYYY): ");
        String pickupDate = scanner.nextLine();
        System.out.print("Enter number of days for the rental: ");
        int days = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Do you want an electronic toll tag at $3.95/day (yes/no)? ");
        boolean tollTag = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Do you want a GPS at $2.95/day (yes/no)? ");
        boolean gps = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Do you want roadside assistance at $3.95/day (yes/no)? ");
        boolean roadsideAssistance = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Enter your current age: ");
        int age = scanner.nextInt();
        double basicRentalCost = 20.0 * days;
        double tollTagCost = tollTag ? 3.95 * days : 0;
        double gpsCost = gps ? 2.95 * days : 0;
        double roadsideAssistanceCost = roadsideAssistance ? 3.95 * days : 0;
        double optionsCost = tollTagCost + gpsCost + roadsideAssistanceCost;
        double underageDriverSurcharge = age < 25 ? 10.0 * days : 0;  //$10/day
        double totalCost = basicRentalCost + optionsCost + underageDriverSurcharge;
        System.out.println("\nRental Car Estimate:");
        System.out.println("---------------------");
        System.out.printf("Basic car rental: $%.2f\n", basicRentalCost);
        System.out.printf("Options cost: $%.2f\n", optionsCost);
        System.out.printf("Underage driver surcharge: $%.2f\n", underageDriverSurcharge);
        System.out.printf("Total cost: $%.2f\n", totalCost);

        scanner.close();
    }
}
