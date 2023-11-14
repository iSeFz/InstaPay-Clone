import java.util.List;

abstract class WalletAccount extends InstaPayAccount {
    public WalletAccount(User user, double balance) {
        super(user, balance);
    }

    public void setbase(String number) {
        user.setPhoneNumber(number);
    }

    public String getbase() {
        return null;
    }

    public abstract void transferMoney(List<InstaPayAccount> instaPayAccounts);
}