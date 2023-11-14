import java.util.List;

abstract class InstaPayWallet extends InstaPayAccount {
    public InstaPayWallet(User user, double balance) {
        super(user, balance);
    }
    public void setbase(String number) {
        user.setPhoneNumber(number);
    }
    public String getbase(){
        return null;
    }
    public abstract void transferMoney(List<InstaPayAccount> instaPayAccounts);
}