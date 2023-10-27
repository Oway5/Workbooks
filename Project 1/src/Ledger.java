import java.util.Scanner;

class Ledger {

    private Homescreen back;

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
        System.out.println("Make a selection:");
        for (String thing : options) { System.out.println(thing); }
        this.awaitSelect();
    }

    public void awaitSelect() {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        char all = 'A';
        char depo = 'D';
        char payments = 'P';
        char home = 'H';
        char exit = 'E';
        char reports = 'R';
        if (in.charAt(0) == all) {
            
        }
        else if (in.charAt(0) == depo) {
            
        }
        else if (in.charAt(0) == payments) {

        }
        else if (in.charAt(0) == home) { back.build(); }
        else if (in.charAt(0) == exit) {
            
        }
        else if (in.charAt(0) == reports) {
            
        }
        scan.close();
    }
}