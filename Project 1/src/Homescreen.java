import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;

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
        System.out.println("[ HOME ]");
        for (String thing : options) { System.out.println(thing); }
        this.awaitSelect();
    }

    public void awaitSelect() {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine().toUpperCase();
        char depo = 'D';
        char pay = 'P';
        char exit = 'X';
        char ledger = 'L';
        if (in.charAt(0) == depo) {
            try { makeTransaction(0); }
            catch (IOException e) { e.printStackTrace(); }
        }
        else if (in.charAt(0) == pay) {
            try { makeTransaction(1); }
            catch (IOException e) { e.printStackTrace(); }
        }
        else if (in.charAt(0) == ledger) {
            Ledger ledge = new Ledger(this);
            ledge.build();
        }
        else if (in.charAt(0) == exit) {
            System.exit(0);
        }
        scan.close();
    }

    public void makeTransaction(int type) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("[ Enter date for transaction in the format YYYY-MM-DD ]");
        boolean dateValid = false;
        String date = "";
        while (dateValid == false) {
            String tempDate = input.nextLine();
            DateValidator validator = new DateValidatorFormatter("YYYY-MM-dd");

            if (tempDate.equals("")) date = LocalDateTime.now().toString();
            
            if (validator.isValid(tempDate) == false) System.out.println("[ Please input a valid date ]");
            else {
                date = tempDate;
                dateValid = true;
            }
        }

        System.out.println("[ Enter time for time in the format HH-mm ]");
        boolean timeValid = false;
        String time = "";
        while (timeValid == false) {
            String tempTime = input.nextLine();
            DateValidator validator = new DateValidatorFormatter("HH-mm");

            if (tempTime.equals("")) time = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
            if (validator.isValid(tempTime) == false) System.out.println("[ Please input a valid time ]");
            else {
                time = tempTime;
                timeValid = true;
            }
        }

        System.out.println("[ Enter description description ]");
        String description = input.nextLine();

        System.out.println("[ Enter vendor for vendor ]");
        String vendor = input.nextLine();

        double amt = 0;
        while (true) {
            System.out.println("[ Enter amount for amount ]");
            try {
                amt = Double.parseDouble(input.nextLine());
                break;
            } catch (NumberFormatException e) { System.out.println("[ Invalid double input ]"); }
        }

        File file = new File("./transactions.csv");

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        if (type == 0) {
            bw.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amt);
        } else if (type == 1) {
            bw.write(date + "|" + time + "|" + description + "|" + vendor + "|-" + amt);
        }

        bw.close();
        fw.close();
        input.close();
        this.build();
    }
}