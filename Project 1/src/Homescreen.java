import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;

class Homescreen {

    public Scanner gScan = new Scanner(System.in);
    
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
        char depo = 'D';
        char pay = 'P';
        char exit = 'X';
        char ledger = 'L';
        boolean nomistake = false;
        while (nomistake == false) {
            String in = gScan.nextLine().toUpperCase();
            if (in.length() == 0) { 
                System.out.println("[ Invalid input ]");
            }
            else if (in.charAt(0) == depo) {
                nomistake = true;
                try { makeTransaction(0); }
                catch (IOException e) { e.printStackTrace(); }
            }
            else if (in.charAt(0) == pay) {
                nomistake = true;
                try { makeTransaction(1); }
                catch (IOException e) { e.printStackTrace(); }
            }
            else if (in.charAt(0) == ledger) {
                nomistake = true;
                Ledger ledge = new Ledger(this);
                ledge.build();
            }
            else if (in.charAt(0) == exit) {
                nomistake = true;
                System.exit(0);
            }
            else {
                System.out.println("[ Invalid input ]");
            }
        }
    }

    public void makeTransaction(int type) throws IOException {

        System.out.println("[ Enter date for transaction in the format YYYY-MM-DD ]");
        boolean dateValid = false;
        String date = "";
        while (dateValid == false) {
            String tempDate = gScan.nextLine();
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
            String tempTime = gScan.nextLine();
            DateValidator validator = new DateValidatorFormatter("HH-mm");

            if (tempTime.equals("")) time = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
            if (validator.isValid(tempTime) == false) System.out.println("[ Please input a valid time ]");
            else {
                time = tempTime;
                timeValid = true;
            }
        }

        System.out.println("[ Enter description description ]");
        String description = gScan.nextLine();

        System.out.println("[ Enter vendor for vendor ]");
        String vendor = gScan.nextLine();

        double amt = 0;
        while (true) {
            System.out.println("[ Enter amount for amount ]");
            try {
                amt = Double.parseDouble(gScan.nextLine());
                break;
            } catch (NumberFormatException e) { System.out.println("[ Invalid double input ]"); }
        }

        File file = new File("./transactions.csv");

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        if (type == 0) {
            bw.append(date + "|" + time + "|" + description + "|" + vendor + "|" + amt);
        } else if (type == 1) {
            bw.append(date + "|" + time + "|" + description + "|" + vendor + "|-" + amt);
        }
        bw.newLine();

        bw.close();
        fw.close();
        this.build();
    }
}