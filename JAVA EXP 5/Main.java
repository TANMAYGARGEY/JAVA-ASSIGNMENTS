import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Customer> customers = new ArrayList<>();
            ArrayList<Account> accounts = new ArrayList<>();

            // Create customers
            Customer c1 = new Customer(101, "Tanmay", "9876543210");
            Customer c2 = new Customer(102, "Rahul", "9123456780");
            Customer c3 = new Customer(103, "Aman", "9988776655");

            customers.add(c1);
            customers.add(c2);
            customers.add(c3);

            // Create accounts
            Account a1 = new SavingsAccount("SA101", c1, 50000, 10000, 5);
            Account a2 = new LoanAccount("LA201", c1, 20000, 50000);
            Account a3 = new SavingsAccount("SA102", c2, 30000, 5000, 4);
            Account a4 = new LoanAccount("LA202", c2, 10000, 30000);
            Account a5 = new Account("AC301", c3, 15000);

            accounts.add(a1);
            accounts.add(a2);
            accounts.add(a3);
            accounts.add(a4);
            accounts.add(a5);

            System.out.println("----- INITIAL ACCOUNT DETAILS -----");
            printAllAccounts(accounts);

            // Transactions
            System.out.println("\n----- PERFORMING TRANSACTIONS -----");

            a1.deposit(5000);
            a1.withdraw(8000);

            a2.withdraw(10000); // taking more loan
            a2.deposit(5000);   // repaying loan

            a3.deposit(2000);
            a4.withdraw(5000);

            a5.deposit(3000);
            a5.withdraw(2000);

            System.out.println("\n----- UPDATED ACCOUNT DETAILS -----");
            printAllAccounts(accounts);

            System.out.println("\n===== CONSOLIDATED CUSTOMER ACCOUNT INFORMATION =====");
            displayCustomerWiseAccounts(customers, accounts);

        } catch (BankingException e) {
            System.out.println("Banking Error: " + e.getMessage());
        }
    }

    public static void printAllAccounts(ArrayList<Account> accounts) {
        for (Account acc : accounts) {
            System.out.println(acc.summary());
        }
    }

    public static void displayCustomerWiseAccounts(ArrayList<Customer> customers, ArrayList<Account> accounts) {
        for (Customer customer : customers) {
            System.out.println("\n" + customer.summary());
            System.out.println("Accounts:");

            boolean found = false;
            double totalAmount = 0;

            for (Account acc : accounts) {
                if (acc.getCustomer().getCustomerId() == customer.getCustomerId()) {
                    found = true;
                    System.out.println("   " + acc.summary());
                    totalAmount += acc.getBalance();
                }
            }

            if (!found) {
                System.out.println("   No accounts found.");
            } else {
                System.out.println("   Total Across Accounts = " + totalAmount);
            }
        }
    }
}