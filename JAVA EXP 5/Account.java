public class Account {
    protected String accountNo;
    protected Customer customer;
    protected double balance;

    public Account(String accountNo, Customer customer, double openingBalance) throws BankingException {
        if (accountNo == null || accountNo.trim().isEmpty()) {
            throw new BankingException("Account number cannot be empty");
        }
        if (customer == null) {
            throw new BankingException("Customer cannot be null");
        }
        if (openingBalance < 0) {
            throw new BankingException("Opening balance cannot be negative");
        }

        this.accountNo = accountNo;
        this.customer = customer;
        this.balance = openingBalance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return "ACCOUNT";
    }

    public void deposit(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new BankingException("Insufficient balance");
        }
        balance -= amount;
    }

    public String summary() {
        return "[" + getAccountType() + "] Account No: " + accountNo +
               ", Holder: " + customer.getName() +
               ", Balance: " + balance;
    }
}