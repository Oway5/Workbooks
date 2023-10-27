import java.util.*;
public class Main{
    public static void main(String[] args){
        System.out.println("Welcome to the Transaction Manager!\n Enter date for transaction");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        System.out.println("Enter time for time");
        String time = input.nextLine();
        System.out.println("Enter description description");
        String description = input.nextLine();
        System.out.println("Enter vendor for vendor");
        String vendor = input.nextLine();
        System.out.println("Enter amount for amount");
        double amount = input.hasNextDouble() ? input.nextDouble() : 0.0;
        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
        }

}