public class LoanAccount extends Account {
    private double loanLimit;

    public LoanAccount(String accountNo, Customer customer, double openingBalance,
                       double loanLimit) throws BankingException {
        super(accountNo, customer, openingBalance);

        if (loanLimit < 0) {
            throw new BankingException("Loan limit cannot be negative");
        }

        this.loanLimit = loanLimit;
    }

    @Override
    public String getAccountType() {
        return "LOAN";
    }

    @Override
    public void deposit(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Repayment amount must be positive");
        }

        balance -= amount;

        if (balance < 0) {
            balance = 0;
        }
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Loan withdrawal amount must be positive");
        }

        if (balance + amount > loanLimit) {
            throw new BankingException("Loan limit exceeded");
        }

        balance += amount;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    @Override
    public String summary() {
        return "[" + getAccountType() + "] Account No: " + accountNo +
               ", Holder: " + customer.getName() +
               ", Outstanding Loan: " + balance +
               ", Loan Limit: " + loanLimit;
    }
}