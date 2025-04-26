package Day2.Extras;
import java.util.*;
public class BankingSystem {
    private Map<Integer, Double> customerAccounts;
    private Map<Integer, Double> sortedAccountsByBalance;
    private Queue<Integer> withdrawalQueue;

    public BankingSystem() {
        customerAccounts = new HashMap<>();
        sortedAccountsByBalance = new TreeMap<>((a, b) -> Double.compare(customerAccounts.get(b), customerAccounts.get(a))); // Sort by balance in descending order
        withdrawalQueue = new LinkedList<>();
    }

    public void addCustomer(int accountNumber, double initialBalance) {
        customerAccounts.put(accountNumber, initialBalance);
        sortedAccountsByBalance.put(accountNumber, initialBalance);
    }

    public void deposit(int accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) + amount);
            sortedAccountsByBalance.put(accountNumber, customerAccounts.get(accountNumber));
        } else {
            System.out.println("Account not found.");
        }
    }

    public boolean withdraw(int accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            double currentBalance = customerAccounts.get(accountNumber);
            if (currentBalance >= amount) {
                customerAccounts.put(accountNumber, currentBalance - amount);
                sortedAccountsByBalance.put(accountNumber, customerAccounts.get(accountNumber));
                withdrawalQueue.add(accountNumber);
                return true;
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
        return false;
    }

    public void processWithdrawalRequests() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber + " with balance: " + customerAccounts.get(accountNumber));
        }
    }

    public void displayAllCustomers() {
        System.out.println("Customer Accounts:");
        for (Map.Entry<Integer, Double> entry : customerAccounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " - Balance: $" + entry.getValue());
        }
    }

    public void displaySortedCustomersByBalance() {
        System.out.println("Customers Sorted by Balance (Descending):");
        for (Map.Entry<Integer, Double> entry : sortedAccountsByBalance.entrySet()) {
            System.out.println("Account " + entry.getKey() + " - Balance: $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        bankingSystem.addCustomer(101, 1000);
        bankingSystem.addCustomer(102, 5000);
        bankingSystem.addCustomer(103, 3000);
        bankingSystem.addCustomer(104, 7000);

        bankingSystem.displayAllCustomers();
        System.out.println();

        bankingSystem.deposit(101, 500);
        bankingSystem.withdraw(103, 1500);
        bankingSystem.withdraw(102, 600);

        bankingSystem.processWithdrawalRequests();
        System.out.println();

        bankingSystem.displaySortedCustomersByBalance();
    }
}
