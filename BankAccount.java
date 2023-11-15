import java.util.List;
import java.util.Scanner;

class BankAccount extends Account {
    public String accountNumber;
    public BankAccount(User user, double balance, String accountNumber) {
        super(user, balance);
        this.accountNumber = accountNumber;
    }
    @Override
    public void setbase(String number) {
        accountNumber = number;
    }

    @Override
    public String getbase() {
        return accountNumber;
    }

    public void transferMoney(List<Account> instaPayAccounts) {
        this.setTransferMoney(new BankTransfer());
        this.transferMoney.transferMoney(instaPayAccounts,this);
    }

}
