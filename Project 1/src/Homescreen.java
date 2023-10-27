import java.util.Scanner;

class Homescreen {
    
    public void build() {
        String[] options = {
            "D: Add Deposit",
            "P: Make Payment (Debit)",
            "L: Ledger",
            "X: Exit"
        };
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Make a selection:");
        for (String thing : options) { System.out.println(thing); }
        this.awaitSelect();
    }

    public void awaitSelect() {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        char depo = 'D';
        char pay = 'P';
        char exit = 'X';
        char ledger = 'L';
        if (in.charAt(0) == depo) {
            addDeposit();
        }
        else if (in.charAt(0) == pay) {
            
        }
        else if (in.charAt(0) == ledger) {
            Ledger ledge = new Ledger(this);
        }
        else if (in.charAt(0) == exit) {
            
        }
        scan.close();
    }

    public void addDeposit() {
        Scanner scan = new Scanner(System.in);
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
    }
}