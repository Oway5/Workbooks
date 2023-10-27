import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reports {
    private Ledger back;
    public Scanner gScan = new Scanner(System.in);

    public Reports(Ledger ledger) {
        this.back = ledger;
    }
    public void build(){

        String[] options = {
            "1: Month to Date",
            "2: Previous Year",
            "3: Previous Month",
            "4: Year to Date",
            "5: Search by Vendor",
            "6: Back to Ledger",
            "0: Exit"
        };

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("[ REPORTS ]");
        for (String thing : options) { System.out.println(thing); }
        this.awaitSelect();
    }
    public void awaitSelect(){
        char monthToDate = '1';
        char previousYear = '2';
        char previousMonth = '3';
        char yearToDate = '4';
        char searchByVendor = '5';
        char backToLedger = '6';
        char exit = '0';
        boolean nomistake = false;
        while (nomistake==false) {
            String in = gScan.nextLine().toUpperCase();
            if (in.length() == 0) {
                System.out.println("[ Invalid input ]");
            } else if (in.charAt(0) == monthToDate) {
                try { displayMonthToDate(); }
                catch (Exception e) { e.printStackTrace(); }
            } else if (in.charAt(0) == previousYear) {
                try { previousYear(); }
                catch (Exception e) { e.printStackTrace(); }
            } else if (in.charAt(0) == previousMonth) {
                try { displayPreviousMonth(); }
                catch (Exception e) { e.printStackTrace(); }
            } else if (in.charAt(0) == yearToDate) {
                try { displayYearToDate(); }
                catch (Exception e) { e.printStackTrace(); }
            } else if (in.charAt(0) == searchByVendor) {
                try { displaySearchByVendor(); }
                catch (Exception e) { e.printStackTrace(); }
            } else if (in.charAt(0) == backToLedger) {
                back.build();
            } else if (in.charAt(0) == exit) {
                System.exit(0);
            }
            else{
                System.out.println("[ Invalid input ]");
            }
            
        }
    }
    public void displaySearchByVendor() throws IOException {
        System.out.println("Search by Vendor");
        System.out.println("Enter Vendor Name: ");
        String vendor = gScan.nextLine();
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] split = line.split("\\|");
                String amt = split[3];
                int display = Integer.compare(amt.indexOf(vendor), 0);
                if (display == 0) { 
                    System.out.println(num + ". " + line);
                }
                num++;
            }
        }
    }
    public void displayYearToDate() throws IOException {
        System.out.println("Year to Date");
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] split = line.split("\\|");
                String amt = split[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(amt, formatter);
                int stringDate = date.getYear();
                int display = Integer.compare(stringDate, LocalDate.now().getYear());
                if (display == 0) { 
                    System.out.println(num + ". " + line);
                }
                num++;
            }
        }
    }
    
    public void displayPreviousMonth() throws IOException {
        System.out.println("Previous Month");
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] split = line.split("\\|");
                String amt = split[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(amt, formatter);
                int stringDate = date.getMonthValue();
                int display = Integer.compare(stringDate, LocalDate.now().getMonthValue() - 1);
                if (display == 0) { 
                    System.out.println(num + ". " + line);
                }
                num++;
            }
        }
    }

    public void previousYear() throws IOException {
        System.out.println("Previous Year");
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] split = line.split("\\|");
                String amt = split[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(amt, formatter);
                int stringDate = date.getYear() - 1;
                int display = Integer.compare(stringDate, LocalDate.now().getYear() - 1);
                if (display == 0) { 
                    System.out.println(num + ". " + line);
                }
                num++;
            }
        }
    }
    
    public void displayMonthToDate() throws IOException {
        System.out.println("Month to Date");
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] split = line.split("\\|");
                String amt = split[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(amt, formatter);
                int stringDate = date.getMonthValue();
                int display = Integer.compare(stringDate, LocalDate.now().getMonthValue());
                if (display == 0) { 
                    System.out.println(num + ". " + line);
                }
                num++;
            }
        }
    }
}
