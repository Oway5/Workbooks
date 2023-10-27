import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Ledger {

    private Homescreen back;
    public Scanner gScan = new Scanner(System.in);

    public Ledger(Homescreen back) {
        this.back = back;
    }

    public void build() {
        String[] options = {
            "A: All entries",
            "D: Deposits",
            "P: Payments",
            "R: Reports",
            "H: Home",
            "E: Exit"
        };

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("[ LEDGER ]");
        for (String thing : options) { System.out.println(thing); }
        this.awaitSelect();
    }

    public void awaitSelect() {
        char all = 'A';
        char depo = 'D';
        char payments = 'P';
        char home = 'H';
        char exit = 'E';
        char reports = 'R';
        boolean nomistake = false;
        while (nomistake == false) {
            String in = gScan.nextLine().toUpperCase();
            if (in.length() == 0) { 
                System.out.println("[ Invalid input ]");
            } else if (in.charAt(0) == all) {
                try { displayAll(); }
                catch (IOException e) { e.printStackTrace(); }
            } else if (in.charAt(0) == depo) {
                try { displayDeposits(); }
                catch (IOException e) { e.printStackTrace(); }
            } else if (in.charAt(0) == payments) {
                try { displayPayments(); }
                catch (IOException e) { e.printStackTrace(); }
            }
            else if (in.charAt(0) == home) { back.build(); }
            else if (in.charAt(0) == exit) { System.exit(0); }
            else if (in.charAt(0) == reports) {
    
            }
        }

    }
    
    public void displayDeposits() throws IOException {
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] split = line.split("\\|");
                double amt = Double.parseDouble(split[split.length - 1]);
                boolean display = Double.compare(amt, 0.0) > 0;
                if (display) { 
                    System.out.println(num + ". " + line);
                }
                num++;
            }
        }

    }

    public void displayPayments() throws IOException {
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] split = line.split("\\|");
                double amt = Double.parseDouble(split[split.length - 1]);
                boolean display = Double.compare(amt, 0.0) < 0;
                if (display) { 
                    System.out.println(num + ". " + line);
                }
                num++;
            }
        }

    }

    public void displayAll() throws IOException {
        File file = new File("./transactions.csv");
        try (Scanner fileReader = new Scanner(file)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(num + ". " + line);
                num++;
            }
        }
    }
}