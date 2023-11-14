import java.util.List;

abstract class InstaPayWallet extends InstaPayAccount {
    public InstaPayWallet(User user, double balance) {
        super(user, balance);
    }
    public abstract void transferMoney(List<InstaPayAccount> instaPayAccounts);
}