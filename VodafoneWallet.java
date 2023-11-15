import java.util.List;
import java.util.Scanner;

class VodafoneWallet extends WalletAccount {
    public VodafoneWallet(User user, double balance) {
        super(user, balance);
    }
    public void transferMoney(List<Account> instaPayAccounts) {
        this.transferMoney.transferMoney(instaPayAccounts,this);
    }
}