public class Transaction {
    private String date;
    private String vendor;
    private String description;
    private double amount;
    private String time;
    //make constructors
    public Transaction(String date,String time, String description, String vendor, double amount){
        this.date = date;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }
}