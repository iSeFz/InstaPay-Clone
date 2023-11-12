public abstract class InstaPayAccount {
    private User user;
    private float balance;
    private String accountType;
    private String accountNumber;

    public InstaPayAccount(User user, float balance, String accountType) {
        this.user = user;
        this.balance = balance;
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public float getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public abstract void transferMoney();

    public void payBill(String biller, float amount) {}

    public abstract void viewTransactionHistory();

    public void inquireBalance() {
        System.out.println("Your Current Balance is " + this.balance);
    }

    public void viewAccountDetails() {
        System.out.println("Account Details");
        System.out.println("------------------------------");
        System.out.println("User Email: " + this.user.getEmail());
        System.out.println("User Phone Number: " + this.user.getPhoneNumber());
        System.out.println("User Address: " + this.user.getAddress());
        System.out.println("Account Type: " + this.accountType);
        System.out.println("Account Holder: " + this.user.getName());
        System.out.println("Account Number: " + this.getAccountNumber());
        System.out.println("Current Balance: " + this.balance);
        System.out.println("------------------------------");
    }
}
