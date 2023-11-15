import java.util.List;

abstract class WalletAccount extends Account {
    public WalletAccount(User user, double balance) {
        super(user, balance);
    }

    public void setbase(String number) {
        user.setPhoneNumber(number);
    }

    public String getbase() {
        return user.getPhoneNumber();
    }

    public abstract void transferMoney(List<Account> instaPayAccounts);
}