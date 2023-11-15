import java.util.List;
import java.util.Scanner;

class EtisalatWallet extends WalletAccount {
    public EtisalatWallet(User user, double balance) {
        super(user, balance);
    }
    public void transferMoney(List<Account> instaPayAccounts) {
        this.setTransferMoney(new WalletTransfer());
        this.transferMoney.transferMoney(instaPayAccounts,this);
    }
}