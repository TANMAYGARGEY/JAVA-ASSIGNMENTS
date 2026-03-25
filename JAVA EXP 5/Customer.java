public class Customer {
    private int customerId;
    private String name;
    private String phone;

    public Customer(int customerId, String name, String phone) throws BankingException {
        if (customerId <= 0) {
            throw new BankingException("Customer ID must be positive");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new BankingException("Customer name cannot be empty");
        }
        if (phone == null || phone.trim().isEmpty()) {
            throw new BankingException("Phone number cannot be empty");
        }

        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String summary() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Phone: " + phone;
    }
}