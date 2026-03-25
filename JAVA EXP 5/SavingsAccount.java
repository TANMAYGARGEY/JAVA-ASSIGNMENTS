public class SavingsAccount extends Account {
    private double minBalance;
    private double interestRate;

    public SavingsAccount(String accountNo, Customer customer, double openingBalance,
                          double minBalance, double interestRate) throws BankingException {
        super(accountNo, customer, openingBalance);

        if (minBalance < 0) {
            throw new BankingException("Minimum balance cannot be negative");
        }
        if (interestRate < 0) {
            throw new BankingException("Interest rate cannot be negative");
        }

        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void deposit(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Deposit amount must be positive");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive");
        }

        if (balance - amount < minBalance) {
            throw new BankingException("Minimum balance must be maintained");
        }

        balance -= amount;
    }

    public void applyAnnualInterest() {
        balance = balance + (balance * interestRate / 100);
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String summary() {
        return "[" + getAccountType() + "] Account No: " + accountNo +
               ", Holder: " + customer.getName() +
               ", Balance: " + balance +
               ", Min Balance: " + minBalance +
               ", Interest Rate: " + interestRate + "%";
    }
}