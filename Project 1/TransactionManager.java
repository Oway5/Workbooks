import java.util.*;

public class TransactionManager {
    // ...

    public List<Transaction> getDeposits() {
        // Return transactions with positive amounts
    }

    public List<Transaction> getPayments() {
        // Return transactions with negative amounts
    }

    public List<Transaction> getTransactionsByVendor(String vendor) {
        // Filter and return transactions based on vendor
    }

    public List<Transaction> getTransactionsByDateRange(String startDate, String endDate) {
        // Filter and return transactions based on date range
    }
    
}